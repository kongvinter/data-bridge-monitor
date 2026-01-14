const { Client } = require('pg');
const express = require('express');
const http = require('http');
const { Server } = require('socket.io');

const app = express();
const server = http.createServer(app);
const io = new Server(server);

const client = new Client({
  user: 'user',
  host: 'db',
  database: 'bridge_db',
  password: 'password',
  port: 5432,
});

app.get('/', (req, res) => {
  res.send(`
    <html>
      <head><title>Monitor TC-02</title></head>
      <body>
        <h1> Event Monitor (Broadcast)</h1>
        <div id="status">socket connected...</div>
        <ul id="lista"></ul>
        <script src="/socket.io/socket.io.js"></script>
        <script>
          const socket = io();
          socket.on('connect', () => { document.getElementById('status').innerText = 'Status: connected'; });
          socket.on('new-data', (data) => {
            const li = document.createElement('li');
            li.innerText = 'Recebido: ' + JSON.stringify(data);
            document.getElementById('lista').prepend(li);
          });
        </script>
      </body>
    </html>
  `);
});


async function readDatabase() {
  try {
    await client.connect();
    console.log(" node connected to database.");


    const res = await client.query('SELECT * FROM raw_records');
    console.log(" data nodes retrieved from database:");
    console.table(res.rows);

    await client.query('LISTEN new_event_channel');
    client.on('notification', (msg) => {
      console.log(" new notification received:");
      const payload = JSON.parse(msg.payload);
      io.emit('new-data', payload);
    });

  } catch (err) {
    console.error("error conection node:", err.stack);
  }
  }
const PORT = 3000;
server.listen(PORT, '0.0.0.0', () => {
  console.log(`server on  http://localhost:${PORT}`);
  readDatabase();
});
