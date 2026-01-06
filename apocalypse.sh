#!/bin/bash
echo "apocalypse: stopping all processes"

cd "$(dirname "$0")"

# clean database state
sudo docker compose down -v

# kill bill Node.js bridge
pkill -f "node listener.js" || echo "node bridge not running."

# kill bill Java Spring Boot
pkill -f "spring-boot" || echo "java backend not running."

# clean ports just in case
fuser -k 3000/tcp 8080/tcp 2>/dev/null

echo "----------------------------------------"
echo "system offline: docker, node and java stopped."
echo "----------------------------------------"
