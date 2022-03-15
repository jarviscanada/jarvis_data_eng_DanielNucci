#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#Make sure there are 5 arguments
if [ $# -ne 5 ]; then
	echo "Please change number of args to 5. (Reference: ./scripts/host_usage.sh psql_host psql_port db_name psql_user psql_password)"
  exit 1
fi

#Store all command outputs that will be reused
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)
timestamp=$(date +"%Y-%m-%d %T")

#Store data that will be inserted into the desired table
memory_free=$(free -m | egrep "^Mem:" | cut -f2 -d":" | awk '{print $3}')
cpu_idle=$(echo "$vmstat_mb" | egrep '^.[0-9]' | xargs | cut -f15 -d" ")
cpu_kernel=$(echo "$vmstat_mb" | egrep '^.[0-9]' | xargs | cut -f14 -d" ")
disk_io=$(vmstat -d | egrep '^sda' | xargs | cut -f11 -d" ")
disk_available=$(df -BM | egrep '/$' | xargs | cut -f4 -d" " | cut -f1 -d"M")

#Find hostname from host_info table
host_id="(SELECT id FROM host_info WHERE hostname='$hostname')";

#Asseble insert statement
insert_stmt="INSERT INTO host_usage(timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available) VALUES('$timestamp', $host_id, '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available')"

#Save the psql password to an environment variable
export PGPASSWORD=$psql_password

#Insert tuple into the table
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?