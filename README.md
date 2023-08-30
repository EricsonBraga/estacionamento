# API Estacionamento
#### Java
#### Spring
#### PostgreSQL
#### Postman

## Definição:
Esta é uma API que faz o controle de um estacionamento:
<p>Armazena dados de clientes. 
<p>Registra horários de entrada e de saída.
<p>Calcula o valor a ser pago de acordo com a permanência.
<p>Retorna o número de vagas disponíveis no momento.

## Funcionalidades:
### Clientes:
- Cadastrar

- Buscar
    - buscar por nome
    - buscar por id
    - buscar pela placa
    - buscar pelo primeiro nome
    - listar histórico de cliente
    - listar todos os clientes
- Editar
    - atualizar nome e placa
    - atualizar nome
    - atualizar placa

- Deletar

### Vagas:
- Criar
    - insere um cliente em uma vaga e registra horário de entrada
- Atualizar
    - atualiza o horário de saída e calcula valor a ser pago
- Buscar
    - busca uma vaga por id
    - busca histórico de vagas de um cliente
    - lista todo o histórico de vagas criadas
    - retorna a quantidade de vagas disponíveis

## Observação:
O Spring estava criando minhas variáveis de tempo (LocalTime) como timestamp no Postgres.<br>
Precisei fazer a alteração manual no sgbd de timestamp para time, <br>
porque estava dando erro na hora de inserir os dados.

## Link Postman:

https://documenter.getpostman.com/view/27254715/2s9Y5ZwhJF