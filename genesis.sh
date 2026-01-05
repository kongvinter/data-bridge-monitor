#!/bin/bash
echo "genesis java-node-docker-psql"

sudo docker compose up -d

code .

cd node-consumer && npm install

sudo docker ps

echo "active genesis'"
