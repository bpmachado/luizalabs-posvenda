# luizalabs-posvenda API - Platafaforma de Comunicação

# Criar a base de dados com nome luizalabs(jdbc:mysql://localhost:3306/luizalabs), a tabela será criada em tempo de execução.
O script SQL esta na raiz do projeto como nome: luizalabs.sql

# A API possui 4 rotas

Inclusão: localhost:8083/agendamento
Body:
{
    "dataEnvio": "2020-09-24 00:22:00",
    "destinatario": "bpmachado@gmail.com",
    "mensagem": "Seja bem vindo",
    "tipoEnvio": 1
}

Consulta por ID:
http://localhost:8083/agendamento/1

Consultar todos os agendamentos:
http://llocalhost:8083/agendamento

Deletar agendamento:
http://localhost:8083/agendamento/1

# Foi utilizado o Postman para realizar a chamada da API.

# Caso não tenha o MYSQL instalado é possivel rodar com banco de dados H2 em memória basta apenas  abrir o arquivo aplication.properties e apagar a linha:
spring.profiles.active=dev

Obrigado!
Bruno Machado
