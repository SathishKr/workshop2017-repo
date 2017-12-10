#!/bin/bash

# you need to create the EC2 Systems Manager Parameter Store for the DB password: my_db_password
password=$(aws ssm get-parameters --region us-west-2 --names /demo/db-password \
    --with-decryption --query Parameters[0].Value|sed 's/^"\(.*\)"$/\1/')

# you need to get DB instance IP from the EC2 console
mvn compile flyway:migrate -Dflyway.user=root -Dflyway.url=jdbc:mysql://34.211.12.228/commentdb \
    -Dflyway.password=$password -Dflyway.baselineOnMigrate=true

