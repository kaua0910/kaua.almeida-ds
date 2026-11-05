const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// Configuração estrita com o seu banco de dados MySQL
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',          
    password: 'kaua0910', // ⚠️ COLOQUE A SUA SENHA DO MYSQL AQUI
    database: 'funcionarios' 
});

db.connect((err) => {
    if (err) {
        console.error('❌ Erro crítico ao conectar no MySQL:', err.message);
        return;
    }
    console.log('🚀 Conectado com sucesso ao banco de dados MySQL!');
});

// GET - Buscar funcionários
app.get('/api/funcionarios', (req, res) => {
    const query = 'SELECT id, nome, funcao, salario FROM funcionarios'; 
    db.query(query, (err, results) => {
        if (err) {
            console.error('Erro no SELECT:', err.message);
            return res.status(500).json({ error: err.message });
        }
        res.json(results); 
    });
});

// POST - Inserir funcionário
app.post('/api/funcionarios', (req, res) => {
    const { nome, funcao, salario } = req.body;
    const query = 'INSERT INTO funcionarios (nome, funcao, salario, status) VALUES (?, ?, ?, "ativo")';
    db.query(query, [nome, funcao, salario], (err, result) => {
        if (err) {
            console.error('Erro no INSERT:', err.message);
            return res.status(500).json({ error: err.message });
        }
        res.status(201).json({ id: result.insertId, nome, funcao, salario });
    });
});

// DELETE - Excluir funcionário
app.delete('/api/funcionarios/:id', (req, res) => {
    const { id } = req.params;
    const query = 'DELETE FROM funcionarios WHERE id = ?';
    db.query(query, [id], (err, result) => {
        if (err) {
            console.error('Erro no DELETE:', err.message);
            return res.status(500).json({ error: err.message });
        }
        res.json({ message: 'Funcionário deletado com sucesso!' });
    });
});

// PUT - Editar funcionário
app.put('/api/funcionarios/:id', (req, res) => {
    const { id } = req.params;
    const { nome, funcao, salario } = req.body;
    const query = 'UPDATE funcionarios SET nome = ?, funcao = ?, salario = ? WHERE id = ?';
    db.query(query, [nome, funcao, salario, id], (err, result) => {
        if (err) {
            console.error('Erro no UPDATE:', err.message);
            return res.status(500).json({ error: err.message });
        }
        res.json({ id, nome, funcao, salario });
    });
});

// Porta alterada para 3001 para não conflitar com processos travados na porta 3000
app.listen(3001, () => {
    console.log('🚀 Servidor rodando em http://localhost:3001');
    console.log('Endpoints: /api/funcionarios (GET/POST/PUT/:id/DELETE/:id)');
});
