# Linux Cluster Monitoring Agent

## Introduction
The Linux Cluster Monitoring Agent is a tool developed to monitor usage statistics nodes in a Linux cluster. Leveraging crontab for scheduling a script to take a snapshot of the usage data every minute. The data is stored in a PostgreSQL database that is deployed on a docker container. Postgres queries have been constructed to both verify data integrity and summarize usage statistics stored within the database. This implementation requires one node in the Linux cluster to contain the PostgreSQL database while all other nodes just need to post to the node containing the database. Potential use cases for this tool include system administrators that need to monitor many servers in a cluster, testing load balancing for compute clusters, and for users that wish to log personal usage data.

## Quick Start
### Prerequisites
For this project you will need:
- to be running CentOS 7 (or equivalent) operating system
- to have crontab installed on all nodes and docker installed on the machine containing the database
- this repository stored locally on all nodes in the cluster

To start from a fresh node:
```bash
# cd to linux_sql/

#create a new PostgreSQL docker container then start it
./scripts/psql_docker.sh create [USERNAME] [PASSWORD] 
./scripts/psql_docker.sh start 

#connect to the psql instance
psql -h localhost -U postgres -W

#create new table and then disconnect from the instance
postgres=# create database host_agent;
postgres=# \q

#create host_info and host_usage tables
psql -h localhost -U postgres -d host_agent -f sql/ddl.sql

#store a snapshot of the current machine's specifications
./scripts/host_info.sh

#edit the current crontab jobs and add the job to the list (making sure to change the path to the correct one)
crontab -e 
# * * * * * bash /PATH_TO_PROJECT/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log

# The tool is now set up and the host_usage table should be filling with usage data from the host machine
```

To start on a node that doesn't need a PostgreSQL database:
```bash
# cd to linux_sql/

#store a snapshot of the current machine's specifications
./scripts/host_info.sh

#edit the current crontab jobs and add the job to the list (making sure to change the path to the correct one)
crontab -e 
# * * * * * bash /PATH_TO_PROJECT/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log

# The tool is now set up and the host_usage table should be filling with usage data from the host machine
```

## Architecture
At the highest level, the Linux Cluster Monitoring Agent is a grouping of nodes that run CentOS 7. The main node contains a PostgreSQL instance that persists all data from all nodes in the cluster. Every node needs to be running a `bash agent`, which consists of two scripts. `host_info.sh` and `host_usage.sh` are the two scripts that the bash agent runs. `host_info.sh` only needs to be run once on a node to capture node hardware information, whereas `host_usage.sh` needs to be run perpetually to store node usage data.

![Architecture Image](https://raw.githubusercontent.com/jarviscanada/jarvis_data_eng_DanielNucci/feature/readme/linux_sql/assets/Architecture.png)

## Implementation
This implementation is an MVP (Minimum Viable Product) written in Bash and PostgreSQL. The main tools used to enable this project are `crontab`, `lscpu`, and `vmstat`. `lscpu` and `vmstat` are used to display hardware and hardware utilization. `crontab` is used to schedule scripts to run at a specified time interval. The MVP was tested in a vacuum of only one node but should work in a cluster environment if the port configuration is correct. 

## Script Description and Usage
### Scripts
- [host_info.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_info.sh) is used to add host device specs to the `host_info` psql table. This script should be run on all nodes that wish to display node usage data.
  - usage: `host_info.sh`

- [host_usage.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_usage.sh) is used to add host device usage data to the `host_usage` psql table. This script is used in combination with crontab to take snapshots every minute.
  - usage: `host_usage.sh`

- [psql_docker.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/psql_docker.sh) is used to start, stop, or create docker containers that contain the PostgreSQL database needed to store all usage and specifications for all devices in the cluster.
  - usage: `psql_docker.sh start|stop|create [username] [password]` (must provide username + password for create)

### SQL Files
- [ddl.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/ddl.sql) is used to create the two tables necessary for the Linux Cluster Monitoring Agent to store data. 
  - usage: `ddl.sql`

- [queries.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/queries.sql) contains queries that can help visualize and debug data from the PostgreSQL database.

### External Application
- [crontab](https://linux.die.net/man/1/crontab) is a program that can schedule scripts to run at a given interval.
A program that schedules jobs
  - usage: `crontab [-u user] file` or `crontab [-u user] { -l | -r | -e }` where -l display's the crontab list to stdout, -r removes the current crontab, -e edits the current crontab

## Database Modeling
### Tables
The PostgreSQL database called `host_agent` contains two tables called `host_info` and `host_usage`. These two tables store hardware specification and usage data respectively. Using these two tables, users can use the queries located in `queries.sql` to see usage data in the cluster.

---
The `host_info` table stores hardware specifications for one device in the cluster which are assumed to not change. Entries are added once when setting up the node with the `host_info.sh` script. This table contains the following columns:
- `id`: Primary key. Unique to each node, this column stores an id number that auto-increments each time a new node is added.
- `hostname`: The full name of the node as per `lscpu`. This is a unique value to each node and is a string value
- `cpu_number`: The number of CPUs in the node as per `lscpu`. 
- `cpu_architecture`: The architecture of the node as per `lscpu` (x86_64, ARM, etc). 
- `cpu_model`: The make and model of the CPU in the node as per `lscpu` (e.g. Intel(R) Xeon(R) CPU @ 2.30GHz). 
- `cpu_mhz`: The clock frequency of the CPU in the node as per `lscpu` (in MHz).
- `l2_cache`: The quantity of L2 cache that the node has as per `lscpu` (in kB).
- `total_mem`: The quantity of total memory the node has as per `free` (in kB).
- `timestamp`: UTC timezone timestamp. Format: yyyy-mm-dd hh:mm:ss.

---
The `host_usage` table stores usage data for all nodes in the cluster that have an entry in the `host_info` table. Entries are added to the `host_usage` table every minute by each node through the use of `crontab` and `host_usage.sh`. This table contains the following columns:
- `timestamp`: UTC timezone timestamp. Format: yyyy-mm-dd hh:mm:ss.
- `host_id`: Foreign Key connected to `host_info.id`. Associates the data in this table with which node in the cluster it comes from.
- `memory_free`: The amount of memory that is free as per the `free` command (in MB). 
- `cpu_idle`: The percentage of the CPU that is not currently in use as per `vmstat`.
- `cpu_kernel`: The percentage of the CPU that is running kernel level commands as per `vmstat`.
- `disk_io`: The number, as an integer, of disk inputs and outputs as per `vmstat`.
- `disk_available`: The quantity of available disk space left on the node as per `df -BM`.

![ER Diagram](https://raw.githubusercontent.com/jarviscanada/jarvis_data_eng_DanielNucci/tree/feature/readme/linux_sql/assets/ERdiagram.png)

## Testing
Because this project's scope was for it to be an MVP (Minimum Viable Product), the testing was conducted on a single node. Upon moving this project to production, one would need to test other nodes posting data to the database. While this project should allow for additional nodes to be placed into the cluster, there has been no testing to verify this. 

Testing on the individual node happened each time after a new feature was implemented. The Bash scripts were straightforward as they contain only a few functionalities per script. Once the scripts could produce expected output while not printing unexpected output, the script was considered tentatively tested. The psql commands and queries were tested after the database was populated with test data from the node. Because all data is from one machine, the psql commands and queries could need some tweaking if this moved deeper into production. After the psql commands aand queries were tested, all parts of the project were assembled and functionality between the layers was checked.

## Deployment
All scripts and related files are stored using this GitHub to allow any node that needs the files for cloning and execution. The current node is hosted using a Google Compute Engine instance with CentOS 7 running on it. The node runs a container using the `postgres:9.6-alpine`  image. This hosts the PostgreSQL database on it. The node then runs a cron job by way of `crontab` to insert data into the `host_usage` table. 

## Improvements
### More Diagnostic Data
The hardware usage data currently being stored suits this project as it is easy to collect from Bash. The way this project could be improved is to store more hardware information on top of what is already being stored. These data points could include metrics like CPU temperature, active processes, memory clock speed, disk maximum I/O speed, and/or network usage. These metrics would likely be unique per use case and should be implemented should this project increase in scope.

### Implementing a Front End
The PostgreSQL and Bash combination on this project makes the Linux Cluster Monitoring Agent lightweight and easy to set up on all nodes. This project should, however, have a front end to help users to visualize or tweak data from the psql database. This also relates to the next improvement: 'Improvements Relating to Scale' as the more data that is added to the database, the more important data visualization is. To implement a front end, one could choose between swapping the database to a cloud-based option (allowing for devices outside the cluster to connect and view data) or allowing only the nodes in the cluster to be able to view the database. These options would be dependent on the use case and should be discussed should this project need to increase data visibility.

### Improvements Related to Scale
Because this project has a small scale, the PostgreSQL database stored on one of the nodes serves its purpose very well. However, if the scale of this project were to increase, so too would the capabilities of this system. PostgreSQL has a default limit of connections of 100. This means that if the number of nodes exceeds 100, the project would need to switch architectures. This could be done by having a database on all nodes, storing data locally, and then posting to a cloud-based database. This could scale the project likely into thousands plus of possible node connections. The use case of the project would still need to guide it in this case.

### Handling Changes in Hardware
Currently, if the hardware of a computer changes, the table that stores host information does not update the entry for the node. Because hardware changes are not oft-occurring, this was not needed with the current scope. If the use case for this project had nodes with frequently changing hardware, a script to update the old entry in `host_info` and remove the outdated information from `host_usage` would need to occur. If all hardware changes were known in advance, this would take the information of the machine before the hardware swap and store it manually outside of the database local to that node. Once the hardware had been swapped the entry matching the old specifications would be updated to the current specifications and the old usage data would be removed. Without knowing hardware changes in advance would make this change more challenging but still possible.

The solution previously outlined was a solution that manually had to be executed. To change the hardware specification data automatically many methods that could work, one of which will now be outlined. If the data on each node is guaranteed to not be corrupted or deleted, each node could store a local copy of their specifications to a local log file. At the time of posting to the database if the specifications are changed from that log file, the `host_uasge.sh` would then update the information to the current specs automatically. But as in all other improvements, this would be heavily dependent on the use case.

### (OS) Operating System Flexibility
The current implementation of the Linux Cluster Monitoring Agent only works with CentOS 7 or an equivalent OS. Some use cases may require a mixture of operating systems, including Windows or macOS. Because the PostgreSQL instance is containerized, it would be trivial to move it to any OS. The main impediment is that commands such as `lscpu` and `vmstat` are not available for these OSs. Once the alternatives to these tools were found for each operating system needed, the Bash scripts would check for the OS and use the correct command for that node's OS.
