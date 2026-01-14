const { Client } = require('pg');
const express = require('express');
const http = require('http');
const { Server } = require('socket.io');

const app = express();
const server = http.createServer(app);
const io = new Server(server, {
    cors: { origin: "*" }
});

const client = new Client({
    connectionString: 'postgresql://user:password@db:5432/bridge_db'
});

client.connect();
client.query('LISTEN new_event_channel');

client.on('notification', (msg) => {
    const payload = JSON.parse(msg.payload);
    console.log("data received from postgres and emitted to socket");
    console.log('Payload:', payload);
    io.emit('new-register', payload);
});

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

server.listen(3000, () => {
    console.log('Server: http://localhost:3000');
});
