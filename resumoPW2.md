```python
from weasyprint import HTML

html_content = """<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<style>
    @page {
        size: A4;
        margin: 15mm 15mm;
        background-color: #0d1117;
    }
    
    *, *::before, *::after {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, Roboto, Helvetica, Arial, sans-serif;
        color: #c9d1d9;
        background-color: #0d1117;
        font-size: 10pt;
        line-height: 1.5;
    }

    /* Markdown README layout style */
    .markdown-body {
        max-width: 100%;
        margin: 0 auto;
    }

    h1 {
        font-size: 18pt;
        color: #58a6ff;
        border-bottom: 1px solid #30363d;
        padding-bottom: 8px;
        margin-top: 0;
        margin-bottom: 16px;
    }

    h2 {
        font-size: 13pt;
        color: #f0f6fc;
        border-bottom: 1px solid #21262d;
        padding-bottom: 6px;
        margin-top: 20px;
        margin-bottom: 12px;
        page-break-after: avoid;
    }

    h3 {
        font-size: 11pt;
        color: #79c0ff;
        margin-top: 14px;
        margin-bottom: 8px;
        page-break-after: avoid;
    }

    p {
        margin-top: 0;
        margin-bottom: 12px;
    }

    ul {
        margin-top: 0;
        margin-bottom: 12px;
        padding-left: 20px;
    }

    li {
        margin-bottom: 4px;
    }

    code {
        font-family: 'Consolas', 'Courier New', Courier, monospace;
        background-color: rgba(110, 118, 129, 0.4);
        color: #f0f6fc;
        padding: 2px 5px;
        border-radius: 4px;
        font-size: 9pt;
    }

    pre {
        background-color: #161b22;
        border: 1px solid #30363d;
        border-radius: 6px;
        padding: 10px;
        overflow: hidden;
        font-family: 'Consolas', 'Courier New', Courier, monospace;
        font-size: 8.5pt;
        color: #e6edf3;
        margin-top: 6px;
        margin-bottom: 12px;
        line-height: 1.4;
    }

    .badge {
        display: inline-block;
        background-color: #238636;
        color: #ffffff;
        font-size: 8pt;
        font-weight: bold;
        padding: 2px 8px;
        border-radius: 12px;
        margin-right: 5px;
    }

    .badge-blue { background-color: #1f6feb; }
    .badge-purple { background-color: #8957e5; }
    .badge-orange { background-color: #d29922; color: #0d1117; }

    .note-box {
        background-color: #161b22;
        border-left: 4px solid #f2cc60;
        padding: 10px 12px;
        margin: 12px 0;
        border-radius: 0 6px 6px 0;
    }

    .note-box-title {
        color: #f2cc60;
        font-weight: bold;
        margin-bottom: 4px;
        font-size: 9pt;
    }

    .caderno-tip {
        background-color: #1f242c;
        border: 1px dashed #388bfd;
        border-radius: 6px;
        padding: 8px 12px;
        margin-top: 6px;
        margin-bottom: 10px;
        color: #a5d6ff;
        font-size: 8.5pt;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 14px;
        font-size: 8.5pt;
    }

    th, td {
        border: 1px solid #30363d;
        padding: 6px 10px;
        text-align: left;
    }

    th {
        background-color: #161b22;
        color: #f0f6fc;
    }

    tr:nth-child(even) {
        background-color: #161b22;
    }
</style>
</head>
<body>
<div class="markdown-body">

    <h1>💻 README.md — Sistema CRUD de Funcionários</h1>
    
    <p>
        <span class="badge badge-blue">ETEC</span>
        <span class="badge badge-purple">Desenvolvimento de Sistemas</span>
        <span class="badge">Full-Stack</span>
        <span class="badge badge-orange">PW2 / BD</span>
    </p>

    <div class="note-box">
        <div class="note-box-title">📝 DICA DE ANOTAÇÃO PARA O CADERNO:</div>
        Este formato segue o padrão de repositórios do GitHub (<code>README.md</code>), ideal para consulta rápida de conceitos, comandos e arquitetura do projeto.
    </div>

    <h2>📌 1. Visão Geral do Projeto</h2>
    <p>Aplicação web para gerenciamento de funcionários baseada nas 4 operações fundamentais (<strong>CRUD</strong>: Create, Read, Update, Delete) utilizando arquitetura Cliente-Servidor.</p>

    <table>
        <thead>
            <tr>
                <th>Camada</th>
                <th>Tecnologia / Bibliotecas</th>
                <th>Função Principal</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>Banco de Dados</strong></td>
                <td>MySQL</td>
                <td>Armazenamento e persistência dos dados.</td>
            </tr>
            <tr>
                <td><strong>Backend (API)</strong></td>
                <td>Node.js, Express, Cors, MySQL2</td>
                <td>Lógica de negócio e rotas de comunicação.</td>
            </tr>
            <tr>
                <td><strong>Frontend</strong></td>
                <td>HTML5, CSS3, JavaScript (DOM + Fetch)</td>
                <td>Interface gráfica e interação com o usuário.</td>
            </tr>
        </tbody>
    </table>

    <div class="caderno-tip">
        ✍️ <strong>No Caderno:</strong> Desenhe o fluxo básico: <code>[ HTML/CSS/JS ] ⇄ (JSON / HTTP) ⇄ [ Node.js Express ] ⇄ (SQL) ⇄ [ MySQL ]</code>
    </div>

    <h2>🗄️ 2. Banco de Dados (MySQL)</h2>
    <p>Script utilizado para criar o banco <code>crud_funcionarios</code> e a tabela principal:</p>

<pre><code>CREATE DATABASE crud_funcionarios;
USE crud_funcionarios;

CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    funcao VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);</code></pre>

    <h3>Destaques das Colunas:</h3>
    <ul>
        <li><code>id INT AUTO_INCREMENT PRIMARY KEY</code>: Identificador único gerado automaticamente.</li>
        <li><code>salario DECIMAL(10,2)</code>: Formato ideal para valores monetários (10 dígitos totais, 2 decimais).</li>
        <li><code>created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP</code>: Preenche a data/hora do cadastro automaticamente.</li>
    </ul>

    <h2>⚙️ 3. Backend (Node.js & API REST)</h2>

    <h3>Dependências (<code>package.json</code>)</h3>
    <ul>
        <li><code>express</code>: Framework web para criação das rotas HTTP.</li>
        <li><code>cors</code>: Libera requisições de origens/portas diferentes (CORS).</li>
        <li><code>mysql2</code>: Permite executar comandos SQL com suporte a Promises (<code>async/await</code>).</li>
    </ul>

    <h3>Endpoints da API (<code>server.js</code> - Porta 3000)</h3>
    <table>
        <thead>
            <tr>
                <th>Método</th>
                <th>Rota</th>
                <th>Ação / Comando SQL</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><code>GET</code></td>
                <td><code>/api/funcionarios</code></td>
                <td><code>SELECT * FROM funcionarios ORDER BY id DESC</code></td>
            </tr>
            <tr>
                <td><code>POST</code></td>
                <td><code>/api/funcionarios</code></td>
                <td><code>INSERT INTO funcionarios (nome, funcao, salario) VALUES (?, ?, ?)</code></td>
            </tr>
            <tr>
                <td><code>PUT</code></td>
                <td><code>/api/funcionarios/:id</code></td>
                <td><code>UPDATE funcionarios SET nome=?, funcao=?, salario=? WHERE id=?</code></td>
            </tr>
            <tr>
                <td><code>DELETE</code></td>
                <td><code>/api/funcionarios/:id</code></td>
                <td><code>DELETE FROM funcionarios WHERE id=?</code></td>
            </tr>
        </tbody>
    </table>

    <div class="caderno-tip">
        💡 <strong>Conceito Chave para Provas:</strong> O uso do símbolo <code>?</code> nos comandos SQL representa <em>Prepared Statements</em>, essencial para prevenir ataques de <strong>SQL Injection</strong>.
    </div>

    <h2>🎨 4. Frontend (Interface Web)</h2>

    <h3>Arquivos da Interface</h3>
    <ul>
        <li><code>index.html</code>: Contém a tabela de dados (<code>&lt;tbody&gt;</code> vazia para preenchimento via JS) e a janela modal do formulário.</li>
        <li><code>style.css</code>: Utiliza Flexbox, responsividade (<code>@media (max-width: 700px)</code>) e animação <code>@keyframes</code> para o surgimento do modal.</li>
        <li><code>script.js</code>: Controla o DOM e se comunica com o backend através da API <code>fetch()</code>.</li>
    </ul>

    <h3>Principais Funções em JavaScript:</h3>
    <ul>
        <li><code>loadItens()</code>: Faz <code>GET</code> na API e renderiza as linhas da tabela dinamicamente.</li>
        <li><code>openModal(edit, index)</code>: Abre o formulário de cadastro ou preenche as entradas para edição.</li>
        <li><code>btnSalvar.onclick</code>: Executa requisição <code>POST</code> (se novo) ou <code>PUT</code> (se edição) enviando os dados em formato <strong>JSON</strong>.</li>
        <li><code>deleteItem(index)</code>: Dispara o método <code>DELETE</code> com a ID selecionada e atualiza a lista.</li>
    </ul>

    <h2>🔄 5. Resumo do Fluxo do CRUD</h2>
    <ol>
        <li>O usuário clica no formulário e dispara a ação no <strong>JavaScript</strong>.</li>
        <li>O JS envia uma requisição HTTP (<strong>Fetch</strong> com payload JSON) para a API Node.js.</li>
        <li>O <strong>Express</strong> valida os dados e executa a instrução na base de dados <strong>MySQL</strong>.</li>
        <li>O MySQL confirma a operação e retorna os dados atualizados para o servidor.</li>
        <li>O servidor devolve uma resposta em JSON e o JS atualiza o <strong>DOM (HTML)</strong> na tela.</li>
    </ol>

</div>
</body>
</html>
"""

with open("README_CRUD_Funcionarios.html", "w", encoding="utf-8") as f:
    f.write(html_content)

HTML("README_CRUD_Funcionarios.html").write_pdf("README_CRUD_Funcionarios.pdf")
print("PDF gerado com sucesso!")


```

```text
PDF gerado com sucesso!


```

Seu resumo estruturado em formato **README.md** está pronto!

Elaborei a estrutura utilizando marcações em **Markdown**, além de caixas de destaque com **"Dicas para o Caderno"** para facilitar a cópia rápida para o seu caderno da ETEC.

---

# 💻 README.md — Sistema CRUD de Funcionários

---

## 📌 1. Visão Geral do Projeto

Aplicação web para gerenciamento de funcionários baseada nas 4 operações fundamentais (**CRUD**: *Create, Read, Update, Delete*) utilizando arquitetura Cliente-Servidor.

| Camada | Tecnologia / Libs | Função Principal |
| --- | --- | --- |
| **Banco de Dados** | MySQL | Armazenamento e persistência dos dados.

 |
| **Backend (API)** | Node.js, Express, Cors, MySQL2 | Lógica de negócio e rotas de comunicação.

 |
| **Frontend** | HTML5, CSS3, JavaScript (DOM + Fetch) | Interface gráfica e interação com o usuário.

 |

> ✍️ **Para copiar no Caderno (Desenhe o Fluxo):**
> `[ HTML/CSS/JS ] ⇄ (JSON / HTTP) ⇄ [ Node.js Express ] ⇄ (SQL) ⇄ [ MySQL ]`

---

## 🗄️ 2. Banco de Dados (MySQL)

Script de criação do banco `crud_funcionarios` e da tabela principal:

```sql
CREATE DATABASE crud_funcionarios;
USE crud_funcionarios;

CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    funcao VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

```

### 📌 Destaques dos Tipos de Dados:

* `id INT AUTO_INCREMENT PRIMARY KEY`: Identificador único e chave primária gerada automaticamente.


* `salario DECIMAL(10,2)`: Formato recomendado para moeda (10 dígitos ao todo, com 2 decimais).


* `created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP`: Registra data/hora da inserção automaticamente.



---

## ⚙️ 3. Backend (Node.js & API REST)

### 📦 Dependências (`package.json`)

* `express`: Framework para criação de rotas e servidor web.


* `cors`: Libera permissão para requisições de origens/portas diferentes.


* `mysql2`: Conecta o Node ao MySQL e permite queries com `async/await`.



### 🛣️ Endpoints da API (`server.js` - Porta 3000)

A aplicação roda na porta 3000 com pool de conexões otimizado (`mysql.createPool`).

| Método HTTP | Rota (Endpoint) | Comando SQL Executado |
| --- | --- | --- |
| `GET` | `/api/funcionarios` | `SELECT * FROM funcionarios ORDER BY id DESC` |
| `POST` | `/api/funcionarios` | `INSERT INTO funcionarios (nome, funcao, salario) VALUES (?, ?, ?)` |
| `PUT` | `/api/funcionarios/:id` | `UPDATE funcionarios SET nome=?, funcao=?, salario=? WHERE id=?` |
| `DELETE` | `/api/funcionarios/:id` | `DELETE FROM funcionarios WHERE id=?` |

> 💡 **Conceito Importante para Prova:**
> O uso de `?` nas queries SQL (Prepared Statements) protege o sistema contra ataques de **SQL Injection**.
> 
> 

---

## 🎨 4. Frontend (Interface do Usuário)

### 📂 Estrutura dos Arquivos

* `index.html`: Define a tabela (com `<tbody>` dinâmica) e a janela modal do formulário.


* `style.css`: Estilização com Flexbox, responsividade (`@media (max-width: 700px)`) e animação `@keyframes` no modal.


* `script.js`: Manipula os elementos da tela e se comunica com o backend via `fetch()`.



### ⚡ Principais Funções JS (`script.js`):

1. `loadItens()`: Faz requisição `GET` na API e monta as linhas (`<tr>`) da tabela dinamicamente.


2. `openModal()` / `editItem()`: Abre o formulário limpo (para criar) ou preenchido (para editar).


3. `btnSalvar.onclick`: Verifica se é um novo cadastro (`POST`) ou atualização (`PUT`) e envia os dados via **JSON**.


4. `deleteItem()`: Dispara a requisição `DELETE` passando o ID do funcionário.



---

## 🔄 5. Resumo do Fluxo do CRUD (Passo a Passo)

1. O usuário preenche o formulário e clica em **Salvar**.


2. O **JavaScript** captura os dados e faz requisição HTTP via **`fetch()`** em formato JSON.


3. O servidor **Express (Node.js)** valida as informações e executa a instrução na base **MySQL**.


4. O **MySQL** processa, salva e devolve a confirmação ao backend.


5. O backend responde para o frontend, e o **JavaScript** atualiza a tabela no **HTML** sem recarregar a página.



---

### 📄 Arquivos em PDF / HTML

Também foi gerado uma cópia visual estilizada em arquivo PDF para você poder salvar ou imprimir:
[file-tag: code-generated-file-d39cf32d-2ca5-4ce9-8fa5-55c81041434d]
