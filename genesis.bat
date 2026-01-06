@echo off
echo [GENESIS] starting java-node-docker-psql...

:: start database
docker-compose up -d

:: start Node.js bridge in background
cd node-consumer
npm install && start /b node listener.js

:: start Java Backend
cd ..
call mvnw.cmd spring-boot:run

echo [OK] active genesis
pause
