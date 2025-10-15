#  onpTarefas - API de Gerenciamento de Tarefas

# Descrição
O **onpTarefas** é uma API REST desenvolvida em **Java (Spring Boot)** para gerenciar tarefas.  
O sistema permite **criar, listar, buscar, atualizar e deletar tarefas**, além de **resetar o banco e o ID** de forma simples via Postman.



# Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Jakarta Persistence**
- **H2 Database / MySQL**
- **Postman** (para testes)
- **Eclipse IDE**


# Estrutura do Projeto
br.com.onp.onpTarefas
│
├── controller
│ └── TarefaController.java
│
├── model
│ └── Tarefa.java
│
├── repository
│ └── TarefaRepository.java
│
└── OnpTarefasApplication.java

# Endpoints da API

| Método | Endpoint | Descrição |
|:------:|:----------|:----------|
| **POST** | `/tarefas` | Cria uma nova tarefa |
| **GET** | `/tarefas` | Lista todas as tarefas |
| **GET** | `/tarefas/{id}` | Busca uma tarefa específica |
| **PUT** | `/tarefas/{id}` | Atualiza os dados de uma tarefa |
| **DELETE** | `/tarefas/{id}` | Deleta uma tarefa pelo ID |
| **DELETE** | `/tarefas/resetar` | Deleta todas as tarefas e reseta o ID para 1 |

---

# Exemplo de Requisição (POST)

**URL:**  
`http://localhost:8080/tarefas`

**Body (JSON):**
```json
{
  "nomeTarefa": "Desenvolvimento da API",
  "responsavel": "Ocimar Prado - RU 4682141",
  "dataEntrega": "2025-12-12"
}

Resposta:

{
  "id": 1,
  "nomeTarefa": "Desenvolvimento da API",
  "dataEntrega": "2025-12-12",
  "responsavel": "Ocimar Prado - RU 4682141"
}


Resetar IDs

Endpoint:
DELETE http://localhost:8080/tarefas/resetar

Função:

Apaga todas as tarefas

Reinicia o contador de IDs para 1

Desenvolvedor:

Ocimar Prado
Curso: Análise e Desenvolvimento de Sistemas
Atividade Prática - Desenvolvimento da API

Observações:

Certifique-se de que o servidor esteja rodando em http://localhost:8080/.

As requisições foram testadas via Postman.

Banco de dados pode ser H2 (memória) ou MySQL (persistente).
