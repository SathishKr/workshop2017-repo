#!/bin/bash

back_dir=/home/ec2-user/backup/$(date +'%F-%T')
mkdir -p $back_dir
if [ -e '/home/ec2-user/javaapp/' ]; then
  mv /home/ec2-user/javaapp $back_dir
fi
