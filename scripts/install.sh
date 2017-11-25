#!/bin/bash


echo 'Install step...'

cd  /home/ec2-user/javaapp
# try to craete the javaapp and log folder
mkdir -p /home/ec2-user/javaapp/log

# start application
# Note: the CodeDeploy agent is waiting for the script it launched to return an exit code and to close stdout and stderr
#       so we have to run it this way. Otherwise it will hang and eventually fail.
/home/ec2-user/javaapp/start.sh > /dev/null 2> /dev/null < /dev/null &

