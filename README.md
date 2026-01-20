### Prerequisites
- [ ] Docker installed
- [ ] Java 21 (JDK)
- [ ] Node.js (LTS)

# Data Bridge Monitor

High-performance Event-Driven Data Pipeline connecting Java to a real-time Web UI via PostgreSQL events and WebSockets.

## System Workflow

[CLIENT] → POST :8080/data → [JAVA] → [POSTGRES] → [NODE] → [WEB MONITOR]

Backend: Spring Boot (Java 21) handles logic and persistence.

Database: PostgreSQL + Trigger fires NOTIFY new_register events.

Bridge: Node.js listens to DB events and broadcasts via Socket.io.

Monitor: Vanilla JS frontend for instant real-time updates.

Getting Started
Option 1: Automated (Recommended)

Linux:

    chmod +x genesis.sh
    ./genesis.sh

Windows: 

    genesis.bat

Option 2: Manual Execution (Step-by-Step)

| Component | Linux  | Windows (CMD/PS) |
| :--- | :--- | :--- |
| **Database** | `docker run --name db...` | Same as Linux |
| **Backend** | `./mvnw spring-boot:run` | `.\mvnw.cmd spring-boot:run` |
| **Bridge** | `npm install && node server.js` | `npm install; node server.js` |
| **Monitor** | `xdg-open index.html` | `start index.html` |

    **Note: Ensure your PostgreSQL trigger is active: CREATE TRIGGER ... AFTER INSERT ... EXECUTE FUNCTION notify_new_register();**

## Testing the Pipeline

With the system running, send a test payload via terminal:

Linux:
Bash

    curl -X POST http://localhost:8080/data \
    -H "Content-Type: application/json" \
    -d '{"content": "socket test"}'

Windows:
PowerShell

    curl.exe -X POST http://localhost:8080/data `
    -H "Content-Type: application/json" `
    -d '{"content": "socket test"}'

Expected Result: Check your Node.js terminal for: "Data received from postgres and emitted to socket"

![Data Bridge Monitor](dbm.png)
