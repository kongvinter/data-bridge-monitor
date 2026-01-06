#!/bin/bash
echo "genesis java-node-docker-psql"

sudo docker compose up -d

code .

cd node-consumer && npm install
node listener.js &

sudo docker ps

cd ..
./mvnw spring-boot:run

echo "active genesis'"
