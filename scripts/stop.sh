#!/bin/bash

# Note: you might want to use systemctl to stop the service if the service has been configured:
# sudo systemctl stop educate.service
# Use this commaind to check the status: sudo systemctl status educate.service

pkill -f java
echo "Killed the java program"
