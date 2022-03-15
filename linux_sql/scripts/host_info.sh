#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#Make sure there are 5 arguments
if [ $# -ne 5 ]; then
	echo "Please change number of args to 5. (Reference: ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password)"
  exit 1
fi

#Store all command outputs that will be reused
lscpu_out=$(lscpu)
hostname=$(hostname -f)
timestamp=$(date +"%Y-%m-%d %T")

#Store data that will be inserted into the desired table
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "^Model name:" | cut -f2 -d":" | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "^CPU MHz:" | cut -f2 -d":" | xargs)
l2_cache=$(echo "$lscpu_out" | egrep "^L2 cache" | cut -f2 -d":" | xargs | cut -f1 -d"K")
total_mem=$(free | egrep "^Mem:" | cut -f2 -d":" | awk '{print $1}')

#Asseble insert statement
insert_stmt="INSERT INTO host_info(hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, total_mem, timestamp) VALUES('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$total_mem', '$timestamp')"

#Save the psql password to an environment variable
export PGPASSWORD=$psql_password

#Insert tuple into the table
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?