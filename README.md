## E-commerce
Projeto Final da disciplina Desenvolvimento de Sistemas Corporativos

## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |


## Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `201` | Requisição foi bem sucedida e que um novo recurso foi criado. (Created).|
| `204` | Requisição foi bem sucedida e o cliente não precisa sair da página atual(No Content).|
| `400` | Erros de validação ou os campos informados não existem no sistema.|
| `401` | Dados de acesso inválidos.|
| `403` | O servidor recebeu a requisição e foi capaz de identificar o autor, porém não autorizou a emissão de um resposta(Forbidden).|
| `404` | Registro pesquisado não encontrado (Not found).|
| `405` | Método não implementado.|
| `410` | Registro pesquisado foi apagado do sistema e não esta mais disponível.|
| `422` | Dados informados estão fora do escopo definido para o campo.|

## Documentação do Swagger

URL da `documentação` http://localhost:8080/swagger-ui.html

## Banco de dados H2

 Driver Class:  `org.h2.Driver` \
 JDBC URL:  `jdbc:h2:mem:testdb` \
 User Name:  `sa` \
 Password::  `Não tem senha`  

## Listar
As ações de `listar` permitem o envio dos seguintes parâmetros:

| Parâmetro | Descrição |
|---|---|
| `filtro` | Filtra dados pelo valor informado. |
| `page` | Informa qual página deve ser retornada. |


# E-commerce Autenticação - Auth

A API utiliza [Auth](http://localhost:8080/login) como forma de autenticação/autorização.


## Solicitando refresh tokens de acesso [/auth/refresh_token]

### Utilizando personal_token [POST]

O `Authorization` é do formato JWT e contém informações da empresa (subdomínio) e do usuário. Este é o token utilizado em sistemas de e-Commerce e sites integrados ao eGestor.

#### Dados para envio no POST
| Parâmetro | Descrição |
|---|---|
| `Content-Type` | Informar: `application/json` |
| `Authorization` | Token JWT com informações da aplicação cliente. |


+ Request (application/json)

    + Body

            {
              "email": "pbexecutores2@gmail.com",
              "senha": "123"
            }


# Group Recursos

# Dados dos clientes [/clientes]

Buscar detalhes da conta.

### Clientes (List) [GET /clientes]

+ Request (application/json)

    + Headers
            Content-Type:  [application/json]
            Authorization: Bearer [access_token]


+ Response 200 (application/json)

               {
                "id": 1,
                "nome": "Maria Silva",
                "email": "pbexecutores2@gmail.com",
                "cpfOuCnpj": "36378912377",
                "tipo": "PESSOAFISICA",
                "enderecos": [
                {
                "id": 1,
                "logradouro": "Rua Flores",
                "numero": "300",
                "complemento": "Apto 303",
                "bairro": "Jardim",
                "cep": "38220834",
                "cidade": {
                "id": 1,
                "nome": "Uberlândia",
                "estado": {
                "id": 1,
                "nome": "Minas Gerais"
                }
                }
                },
                {
                "id": 2,
                "logradouro": "Avenida Matos",
                "numero": "105",
                "complemento": "Sala 800",
                "bairro": "Centro",
                 "cep": "38777012",
                "cidade": {
                "id": 2,
                "nome": "São Paulo",
                "estado": {
                "id": 2,
                "nome": "São Paulo"
                }
                }
                }
                ],
                "telefones": [
                "27363323",
                "93838393"
                 ],
                "perfis": [
                "CLIENTE"
                ]
            }
            
+ Response 403 (application/json)

          {
             "timestamp": 1670372229955,
             "status": 403,
             "error": "Acesso negado",
             "message": "Acesso negado",
             "path": "/clientes/4"
          }


# Pedidos [/pedidos]

Os pedidos podem ser clientes, categoria, produtos, estados.

### Listar (List) [GET /contatos{?filtro,endereco,telefone,email,clienteFinal,indIE,IE,IM,suframa,obs,fields,orderBy}]
+ Parameters
    + filtro (string, optional) - Busca a string informada nos campos: nome, fantasia, código, contato, email, telefone e tags.
    + endereco (string, optional) - Busca a string informada no endereço do contato (rua, cep, bairro, cidade e estado)
    + telefone (string, optional) - Busca o valor informado no campo "Telefones" do contato
    + email (string, optional) - Busca o valor informado no campo "E-mails" do contato


+ Request (application/json)

    + Headers

            Content-Type:  [application/json]
            Authorization: Bearer [access_token]

+ Response 200 (application/json)
 
            {
                    "id": 1,
                    "instante": "30/09/2017 13:32",
                    "pagamento": {
                    "@type": "pagamentoComCartao",
                    "id": 1,
                    "estado": "QUITADO",
                    "numeroDeParcelas": 6
                    },
                    "cliente": {
                    "id": 1,
                    "nome": "Maria Silva",
                    "email": "pbexecutores2@gmail.com",
                    "cpfOuCnpj": "36378912377",
                    "tipo": "PESSOAFISICA",
                    "enderecos": [
                    {
                    "id": 1,
                    "logradouro": "Rua Flores",
                    "numero": "300",
                    "complemento": "Apto 303",
                    "bairro": "Jardim",
                    "cep": "38220834",
                    "cidade": {
                    "id": 1,
                    "nome": "Uberlândia",
                    "estado": {
                    "id": 1,
                    "nome": "Minas Gerais"
                    }
                    }
                    },
                    {
                    "id": 2,
                    "logradouro": "Avenida Matos",
                    "numero": "105",
                    "complemento": "Sala 800",
                    "bairro": "Centro",
                    "cep": "38777012",
                    "cidade": {
                    "id": 2,
                    "nome": "São Paulo",
                    "estado": {
                    "id": 2,
                    "nome": "São Paulo"
                    }
                    }
                    }
                    ],
                    "telefones": [
                    "27363323",
                    "93838393"
                    ],
                    "perfis": [
                    "CLIENTE"
                    ]
                    },
                    "enderecoDeEntrega": {
                    "id": 1,
                    "logradouro": "Rua Flores",
                    "numero": "300",
                    "complemento": "Apto 303",
                    "bairro": "Jardim",
                    "cep": "38220834",
                    "cidade": {
                    "id": 1,
                    "nome": "Uberlândia",
                    "estado": {
                    "id": 1,
                    "nome": "Minas Gerais"
                    }
                    }
                    },
                    "itens": [
                    {
                    "desconto": 0.0,
                    "quantidade": 1,
                    "preco": 2000.0,
                    "subTotal": 2000.0,
                    "produto": {
                    "id": 1,
                    "nome": "Computador",
                    "preco": 2000.0
                    }
                    },
                    {
                    "desconto": 0.0,
                    "quantidade": 2,
                    "preco": 80.0,
                    "subTotal": 160.0,
                    "produto": {
                    "id": 3,
                    "nome": "Mouse",
                    "preco": 80.0
                    }
                    }
                    ],
                    "valorTotal": 2160.0
            }
              

+ Response 403 (application/json)

          {
             "timestamp": 1670372185204,
              "status": 404,
              "error": "Não encontrado",
              "message": "Objeto não encontrado! Id: 4, Tipo: com.br.projeto.springbootmc.domain.Pedido",
              "path": "/pedidos/4"
          }


### Estados (List) [GET /estados]

+ Request (application/json)

    + Headers

            Content-Type:  [application/json]
            Authorization: Bearer [access_token]


+ Response 200 (application/json)

               {
               "id": 1,
                 "nome": "Minas Gerais"
                },
                {
                "id": 2,
                "nome": "São Paulo"
            }
            
+ Response 403 (application/json)

          {
             "timestamp": 1670373501454,
             "status": 404,
             "error": "Not Found",
             "message": "No message available",
             "path": "/estados/1"
          }

### Produtos (List) [GET /produtos]

+ Request (application/json)

    + Headers

            Content-Type:  [application/json]
            Authorization: Bearer [access_token]


+ Response 200 (application/json)

               {
                 "id": 1,
                 "nome": "Computador",
                 "preco": 2000.0
                },
                {
                 "id": 2,
                 "nome": "Impressora",
                 "preco": 800.0
                },
                "id": 3,
                 "nome": "Mouse",
                 "preco": 80.0
                },
                "id": 4,
                 "nome": "Mesa de escritório",
                 "preco": 300.0
                },
                "id": 5,
                 "nome": "Toalha",
                 "preco": 50.0
                },
                "id": 6,
                 "nome": "Colcha",
                 "preco": 200.0
                },
                "id": 7,
                 "nome": "TV true color",
                 "preco": 1200.0
                },
                "id": 8,
                 "nome": "Roçadeira",
                 "preco": 800.0
                },
                "id": 9,
                 "nome": "Abajour",
                 "preco": 100.0
                },
               
            }
            
+ Response 403 (application/json)

          {
                "timestamp": 1670373911424,
                "status": 404,
                "error": "Não encontrado",
                "message": "Objeto não encontrado! Id: 60, Tipo: com.br.projeto.springbootmc.domain.Produto",
                "path": "/produtos/60"
          }


### Novo Clientes (Create) [POST]


   
+ Request (application/json)

    + Headers

            Content-Type:  [application/json]
            Authorization: Bearer [access_token]

    + Body

            {
                "nome" : "João da Silva",
                "email" : "joao@gmail.com",
                "cpfOuCnpj" : "39044683756",
                "tipo" : 1,
                "telefone1" : "997723874",
                "telefone2" : "32547698",
                "logradouro" : "Rua das Acácias",
                "numero" : "345",
                "complemento" : "Apto 302",
                "cep" : "38746928",
                "cidadeId" : 2
            }

+ Response 200 (application/json)
