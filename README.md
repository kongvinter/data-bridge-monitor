# data-bridge-monitor
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![NodeJS](https://img.shields.io/badge/Node.js-20-green?style=for-the-badge&logo=node.js)
![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge&logo=docker)

*Prerequisites: > - Docker & Docker Compose installed.*

[ JAVA PRODUCER ] --(JDBC)--> [ POSTGRES DB ] <--(SQL)-- [ NODE CONSUMER ]
      (Port 8080)              (Port 5432)               (Logs/Output)

setup linux / mac :genesis.sh (init) , apocalypse.sh (end)
setup windons :genesis.bat (init) , apocalypse.bat (end)

flux : [CLIENTE] → POST :8080/data → [JAVA] → [POSTGRES] ← [NODE] → CONSOLE

send data : curl -X POST http://localhost:8080/data -d '{"msg": "test message"}'

logs : docker logs -f node-consumer
