#! /bin/sh

#Obtain CLI args
cmd=$1
db_username=$2
db_password=$3

#Start docker if status command fails
sudo systemctl status docker --quiet|| sudo systemctl start docker

#check container status
docker_inspect=$(docker container inspect jrvs-psql)
container_status=$(echo "$docker_inspect" | egrep "Status" | cut -f2 -d":" | cut -f1 -d","  | xargs)

#User switch case to handle create|stop|start options
case $cmd in
  create)

  #check # of CLI arguments
  if [ $# -ne 3 ]; then
    echo 'Create requires username and password'
    exit 1
  fi

  # Check if the container is already active or non-active
  if [ "$container_status" == "running" ] || [ "$container_status" == "exited" ]; then
		echo 'Container already exists'
		exit 1
	fi

  #Create container
	docker volume create pgdata
	docker run --name jrvs-psql -e POSTGRES_PASSWORD="$password" -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
	exit 0
	;;

  start|stop)
  #check instance status; exit 1 if container has not been created
  if [ "$container_status" == "" ]; then
    echo 'Container does not exist'
    exit 1
  fi

  #Start or stop the container
	docker container "$cmd" jrvs-psql
	exit 0
	;;

  *)
	echo 'Illegal command'
	echo 'Commands: start|stop|create'
	exit 1
	;;
esac