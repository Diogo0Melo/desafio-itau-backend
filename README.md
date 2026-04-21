# [🏦 Desafio Itaú - Backend](./INSTRUCTIONS.md)

<img width="1920" height="1080" alt="ApiDesafioItauBackEnd" src="https://github.com/user-attachments/assets/60b40b01-1fa9-485e-aa5a-f5ba74212531" />

API REST em Kotlin e Spring Boot para processamento de transações e cálculo de estatísticas em tempo real com armazenamento em memória.

---

## 📁 Estrutura do Projeto e Decisões Técnicas

O projeto foi estruturado seguindo princípios de código limpo, separação de responsabilidades (Controller, Service, Repository):

* 🧠 **Armazenamento em Memória**: Atendendo aos requisitos do desafio, não há banco de dados externo. A persistência é gerida de forma local e otimizada utilizando as coleções nativas do Kotlin (`RepositoryMemoryImpl`).
* 🛡️ **Tratamento Global de Erros (Requisito Extra)**: Implementação de um `GerenciadorDeErros` (`@RestControllerAdvice`) para interceptar exceções e retornar respostas HTTP claras e amigáveis (422 para regras de negócio violadas e 400 para JSON malformado).
* 🎲 **Seeder Automático**: Para facilitar a testabilidade, o `TransacaoSeeder` injeta automaticamente 1.000 transações aleatórias na memória sempre que a aplicação é iniciada.

## 🔌 Documentação da API (Endpoints)

### 1. Cadastrar Transação (`POST /transacao`)
Recebe e registra uma nova transação financeira. 

**Corpo da Requisição (JSON):**
```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```
**Respostas Esperadas:**
* `201 Created`: Transação aceita e registrada.
* `422 Unprocessable Entity`: Transação inválida (ex: valor negativo ou data no futuro).
* `400 Bad Request`: JSON malformado.

### 2. Calcular Estatísticas (`GET /estatistica`)
Retorna métricas matemáticas de todas as transações cadastradas que ocorreram **estritamente nos últimos 60 segundos**.

**Resposta Esperada (200 OK):**
```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

### 3. Limpar Dados (`DELETE /transacao`)
Exclui imediatamente todas as transações que estão salvas na memória da aplicação. Retorna `200 OK` com os dados apagados com sucesso.

## 💻 Tecnologias e Ferramentas Utilizadas
* 🟣 **Kotlin**
* 🍃 **Spring Boot**
* ☕ **JDK 21**
* 🐘 **Gradle**
* 🛡️ **Bean Validation**
* 🚀 **Postman**
* 💻 **IntelliJ IDEA**
* 🐙 **Git e GitHub**

## 🎯 Objetivo
Este projeto foi desenvolvido como um exercício prático para consolidar conhecimentos em Kotlin e Spring Boot. O foco principal foi aplicar conceitos de lógica de programação e arquitetura de software.

## 🚀 Como Executar (Passo a Passo)

**Pré-requisitos:**
*   JDK 21 ou superior.
*   Uma IDE para Java/Kotlin, como o [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
*   Git.

### 🛠️ Rodando o Projeto via IDE (Recomendado)
1. **Clone o repositório** para a sua máquina:
   ```bash
   git clone https://github.com/diogo0melo/desafio-itau-backend.git
   ```
2. **Abra o projeto na sua IDE**:
   * No IntelliJ IDEA, vá em `File > Open...` e selecione a pasta `desafio-itau-backend` que você acabou de clonar.
   * Aguarde a IDE sincronizar o projeto com o Gradle e baixar todas as dependências.
3. **Execute a aplicação**:
   * Encontre a classe principal da aplicação, nomeada `DesafioItauBackendApplication.kt`.
   * Clique com o botão direito no arquivo e selecione a opção **"Run 'DesafioItauBackendApplication.kt'"**.
4. **Verifique a execução**:
   * O console da IDE mostrará os logs de inicialização do Spring Boot. A API estará rodando localmente na porta padrão `8080`.
5. **Teste a API**:
   * Acesse `http://localhost:8080/` no seu navegador. Se visualizar a mensagem `"API is running"`, o servidor está pronto para receber requisições via Postman ou outro cliente HTTP.

---
👨‍💻 **Desenvolvido por Diogo Melo**
