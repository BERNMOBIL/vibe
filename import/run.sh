#!/bin/bash
password=''
if [ -n $2 ]
then
    echo "Enter postgres password"
    read -s $password
else
    $password=$2
fi
sed -i -- 's/""//g' /tmp/gtfs/routes.txt
psql -U $1 -d vibe < import-static-data.sql
