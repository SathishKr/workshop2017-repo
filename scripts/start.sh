#!/bin/bash

cd  /home/ec2-user/javaapp
export JAVA_HOME=/usr
export JRE_HOME=/usr
export PATH=$PATH:/usr/bin

#nohup java -Xmx1024m -Xms1024m -jar devops-workshop-0.0.1-SNAPSHOT.jar 2>&1 >> /home/ec2-user/javaapp/log/log.txt &
aws s3 cp s3://aws-workshop2017-us-west-2-793169309996-project-1/config/application.properties .
nohup java -Xmx1024m -Xms1024m -Dspring.config.location=./application.properties \
    -jar devops-workshop-0.0.1-SNAPSHOT.jar 2>&1 >> /home/ec2-user/javaapp/log/log.txt &

echo "Started application..."

