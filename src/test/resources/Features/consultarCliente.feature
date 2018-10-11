# language: pt
Funcionalidade: login Usuario 

	Usuario podera  logar no sistema com usuario valido, consultar cliente cadastrado
	
	pré-requesitos: possuir um usuario valido e preencher os campos obrigatorios 


Contexto: Como um usuário válido, posso logar no sistema
	Dado que estou logado como Admin
    Quando digitar "admin" e "admin" válidas
    E clica no botão login
    Então devera acessar a Home do sistema    

@consultarCliente
Esquema do Cenário: Consultar cadastrado no sistema
    E clicar em QA
    E clicar em cliente
    E clicar em Listar
    Então devera acessar a tela "Listar Clientes"
    E Preencher "<nome>" , "<data>"
    E clicar em pesquisar
    Entao devera ser apresentado usuario consultado  
Exemplos:
|nome			|data	|
|mike automacao	|102019	|


@consultarClienteSemDados
Cenário: Validar  cadastrado no sistema sem preencher campos
    E clicar em QA
    E clicar em cliente
    E clicar em Listar
    E clicar em pesquisar
    Entao sistema devera apresentar aviso de preencher campos obrigatorios