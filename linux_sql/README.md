# Linux Cluster Monitoring Agent

## Introduction
The Linux Cluster Monitoring Agent is a tool developed to monitor usage statistics nodes in a Linux cluster. Leveraging crontab for scheduling a script to take a snapshot of the usage data every minute. The data is stored in a PostgreSQL database that is deployed on a docker container. Postgres queries have been constructed to both verify data integrity and summarize usage statistics stored within the database. This implementation requires one node in the Linux cluster to contain the PostgreSQL database while all other nodes just need to post to the node containing the database. Potential use cases for this tool include: system administrators that need to monitor many servers in a cluster, testing load balancing for compute clusters, and for users that wish to log personal usage data.

## Quick Start
### Prerequisites
For this project you will need:
- to be running centOS 7 (or equivalent) operating system
- to have crontab installed on all machines and docker installed on the machine containing the database
- this repository stored locally on all machines in the cluster

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

To start on a node with the Docker container and PSQL database installed:
```bash
# cd to linux_sql/

#start the PostgreSQL docker container
./scripts/psql_docker.sh start

#store a snapshot of the current machine's specifications
./scripts/host_info.sh

#edit the current crontab jobs and add the job to the list (making sure to change the path to the correct one)
crontab -e 
# * * * * * bash /PATH_TO_PROJECT/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log

# The tool is now set up and the host_usage table should be filling with usage data from the host machine
```

## Architecture
Describe the architecture, provide the diagram created, and make sure to create and populate the assets directory with the correct photo.

## Implementation
Go into greater depth explaining how and why the Linux Cluster Monitoring Agent runs the way it does.

## Script Description and Usage
### Scripts
- [host_info.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_info.sh) is used to add host device specs to the `host_info` psql table. This script should be run on all device that wish to display usage data.
  - usage: `host_info.sh`

- [host_usage.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_usage.sh) is used to add host device usage data to the `host_usage` psql table. This script is used in combination with crontab to take snapshots every minute.
  - usage: `host_usage.sh`

- [psql_docker.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/psql_docker.sh) is used to start, stop, or create docker containers that contain the PostgreSQL database needed to store all usage / specifications for all devices in the cluster.
  - usage: `psql_docker.sh start|stop|create \[username\] \[password\]` (must provide username + password for create)

### SQL Files
- [ddl.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/ddl.sql) is used to create the two teables necessary for the Linux Cluster Monitoring Agent to store data. 
  - usage: `ddl.sql`

- [queries.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/queries.sql) contains queries that can help visualize and debug data from the PostgreSQL database.

### External Application
- [crontab](https://linux.die.net/man/1/crontab) is a program that can schedule scripts to run on a given interval.
A program that schedules jobs
  - usage: `crontab [-u user] file` or `crontab [-u user] { -l | -r | -e }` where -l display's the crontab list to stdout, -r removes the current crontab, -e edits the current crontab

## Database Modeling
### Tables
The PostgreSQL database called `host_agent` contains two tables called `host_info` and `host_usage`. These two tables store hardware specification and usage data respectively. Using these two tables, users can use the queries located in `queries.sql` to see usage data in the cluster.

---
The `host_info` table stores hardware specifications for one device in the cluster which are assumed to not change. Entries are added once when setting up the node with the `host_info.sh` script. This table contains the following columns:
- `id`: Primary key. Unique to each node, this column stores an id number that auto-increments each time a new node is added.
- `hostname`: The full name of the node as per `lscpu`. This is a unique value to each node and is a string value
- `cpu_number`: The number of CPUs in the node as per  `lscpu`. 
- `cpu_architecture`: The architecture of the node as per `lscpu` (x86_64, ARM, etc). 
- `cpu_model`: The make and model of the CPU in the node as per `lscpu` (e.g. Intel(R) Xeon(R) CPU @ 2.30GHz). 
- `cpu_mhz`: The clock frequency of the CPU in the node as per `lscpu` (in MHz).
- `l2_cache`: The quantity of L2 cache that the node has as per `lscpu` (in kB).
- `total_mem`: The quantity of total memory the node has as per `free` (in kB).
- `timestamp`: UTC timezone timestamp. Format: yyyy-mm-dd hh:mm:ss.

---
The `host_usage` table stores usage data for all nodes in the cluster that have an entry in the `host_info` table. Entries are added to the `host_usage` table every minute by each node through the use of `crontab` and `host_usage.sh`. This table contains the following columns:
- `timestamp`: UTC timezone timestamp. Format: yyyy-mm-dd hh:mm:ss.
- `host_id`: Foreign Key connected to `host_info.id`. Assocciates the data in this table with which node in the cluster it come from.
- `memory_free`: The amount of memory that is free as per the `free` command (in MB). 
- `cpu_idle`: The percentage of the CPU that is not currently in use as per `vmstat`.
- `cpu_kernel`: The percentage of the CPU that is running kernel level commands as per `vmstat`.
- `disk_io`: The number, as an integer, of disk inputs and outputs as per `vmstat` .
- `disk_available`: The quantity of available disk space left on the node as per `df -BM`.

## Testing
Hand tested all functionality as the scope of this project was relatively small. When improvements are implemented, testing will need to be more robust.

## Deployment
Deployed on a Google compute cluster that contains a psql container. 

## Improvements
### More Diagnostic Data

### Implementing a Front End

### Handling Changes in Hardware

### Improvements Related to Scale

### Operating System Flexibility
