Prerequisites:Docker,Java 21,Node.js

Data Bridge Monitor

High-performance Event-Driven Data Pipeline connecting Java to a real-time Web UI via PostgreSQL events and WebSockets.
🔄 System Workflow

[CLIENT] → POST :8080/data → [JAVA] → [POSTGRES] → [NODE] → [WEB MONITOR]

    Backend: Spring Boot (Java 21) handles logic and persistence.

    Database: PostgreSQL + Trigger fires NOTIFY new_register events.

    Bridge: Node.js listens to DB events and broadcasts via Socket.io.

    Monitor: Vanilla JS frontend for instant real-time updates.

🚀 Getting Started
Option 1: Automated (Recommended)

    Fedora/Linux:
    Bash

    chmod +x genesis.sh
    ./genesis.sh

Windows: Run genesis.bat from the terminal or double-click it.
Option 2: Manual Execution (Step-by-Step)

Run each command in a separate terminal to monitor live logs:
Component	🐧 Linux 	🪟 Windows (CMD/PS)
1. Database	docker run --name db -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres	Same as Linux
2. Backend	./mvnw spring-boot:run	.\mvnw.cmd spring-boot:run
3. Bridge	npm install && node server.js	npm install; node server.js
4. Monitor	xdg-open index.html	start index.html

    ⚠️ Note: Ensure your PostgreSQL trigger is active: CREATE TRIGGER ... AFTER INSERT ... EXECUTE FUNCTION notify_new_register();

🧪 Testing the Pipeline

With the system running, send a test payload via terminal:

Linux:
Bash

curl -X POST http://localhost:8080/data \
-H "Content-Type: application/json" \
-d '{"content": "socket test"}'

Windows (PowerShell):
PowerShell

curl.exe -X POST http://localhost:8080/data `
-H "Content-Type: application/json" `
-d '{"content": "socket test"}'

Expected Result: Check your Node.js terminal for: "Data received from postgres and emitted to socket"

![Data Bridge Monitor](dbm.png)
