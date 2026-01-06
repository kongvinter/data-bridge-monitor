@echo off
echo [APOCALYPSE] stopping all processes...

:: stop and clean docker containers
docker-compose down -v

::  kill bill Node.js process
taskkill /F /IM node.exe /T 2>nul

:: kill bill Java/Spring process
for /f "tokens=5" %%a in ('netstat -aon ^| findstr :8080') do taskkill /F /PID %%a 2>nul

echo.
echo [OK] system offline.
pause
