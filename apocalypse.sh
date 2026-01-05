#!/bin/bash
echo "stop process."

# 1. Entrar na pasta onde o script está (garante que acha o docker-compose.yml)
cd "$(dirname "$0")"

echo "containers shutdown."

sudo docker compose down

echo "node process shutdown."

pkill -f "node index.js" || echo "No Node.js process found."

echo "----------------------------------------"
echo "node and docker containers stopped."
echo "java still on."
echo "----------------------------------------"

# Mostra o status final (deve aparecer vazio ou 'Exited')
sudo docker ps -a
