const { Client } = require('pg');

const client = new Client({
  user: 'user',
  host: 'localhost',
  database: 'bridge_db',
  password: 'password',
  port: 5432,
});

async function readDatabase() {
  try {
    await client.connect();
    console.log(" Node.js conectado ao Banco de Dados com sucesso");


    const res = await client.query('SELECT * FROM raw_records');

    console.log(" Dados encontrados pelo Node:");
    console.table(res.rows);

  } catch (err) {
    console.error("❌ Erro de conexão no Node:", err.stack);
  } finally {
    await client.end();
  }
}

readDatabase();
