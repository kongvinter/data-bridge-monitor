Prerequisites:Docker,Java 21,Node.js

Data Bridge Monitor

This project implements a high-performance Event-Driven Data Pipeline that connects a Java ecosystem to a real-time web interface using PostgreSQL events and WebSockets via Node.js.
🔄 System Workflow

[CLIENT] → POST :8080/data → [JAVA] → [POSTGRES] → [NODE] → [WEB MONITOR]

    Backend: Persists data and handles business logic using Spring Boot.

    Database: Utilizes a PostgreSQL trigger to fire NOTIFY new_register events.

    Bridge: A Node.js listener that captures DB events and broadcasts them via Socket.io.

    Monitor: A Vanilla JS frontend that receives updates instantly without page refreshes.

🛠️ Tech Stack

    Java 21 & Spring Boot (REST API)

    PostgreSQL (Native Event Triggering)

    Node.js & Socket.io (Real-time Bridge)

    Docker (Database Containerization)

🚀 Getting Started (Fedora/Linux)

The project includes automated lifecycle scripts to manage the environment:

    Start the System:
    Bash

./genesis.sh

(This script handles Docker containers, Java builds, and starts the Node.js server)

Stop and Clean:
Bash

    ./apocalypse.sh

🧪 Testing the Pipeline

With the system running and index.html open in your browser, send a test payload via terminal:
Bash

curl -X POST http://localhost:8080/data \
     -H "Content-Type: application/json" \
     -d '{"content": "socket test"}'

Node.js Logs: Check your terminal to confirm the broadcast:

"Data received from postgres and emitted to socket"

![Data Bridge Monitor](dbm.png)
