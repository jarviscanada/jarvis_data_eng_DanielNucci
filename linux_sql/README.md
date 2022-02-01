# Linux Cluster Monitoring Agent

## Introduction
The Linux Cluster Monitoring Agent is a tool developed to monitor usage statistics nodes in a Linux cluster. Leveraging crontab for scheduling a script to take a snapshot of the usage data every minute. The data is stored in a PostgreSQL database that is deployed on a docker container. Postgres queries have been constructed to both verify data integrity and summarize usage statistics stored within the database. This implementation requires one device in the Linux cluster to contain the PostgreSQL database while all other devices just need to post to this centralized database. Potential use cases for this tool include: system administrators that need to monitor many servers in a cluster, testing load balancing for compute clusters, and for users that wish to log personal usage data.

## Quick Start
### Prerequisites
For this project you will need:
- to be running centOS 7 (or equivalent) operating system
- to have crontab installed on all machines and docker installed on the machine containing the database
- this repository stored locally on all machines in the cluster

To start from fresh:
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

To start on a machine with the Docker container and PSQL database installed:
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
- [host_info.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_info.sh) is used to add host device specs to the host_info psql table. This script should be run on all device that wish to display usage data.

- [host_usage.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/host_usage.sh) is used to add host device usage data to the host_usage psql table. This script is used in combination with crontab to take snapshots every minute.

- [psql_docker.sh](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/scripts/psql_docker.sh) is used to start, stop, or create docker containers that contain the Postgres database needed to store all usage / specifications for all devices in the cluster.

### SQL Files
- [ddl.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/ddl.sql) 

- [queries.sql](https://github.com/jarviscanada/jarvis_data_eng_DanielNucci/blob/main/linux_sql/sql/queries.sql) 

### External Tool
- [crontab](https://linux.die.net/man/1/crontab)
A program that schedules jobs

## Database Modeling
Schema of the DB + some diagrams

## Testing
Hand tested all functionality as the scope of this project was relatively small. When improvements are implemented, testing will need to be more robust.

## Deployment
Deployed on a Google compute cluster that contains a psql container. 

## Improvements
### More Diagnostic Data

### Implementing a Front End

### Handling Changes in Hardware

### Improvements Related to Scale

### 
