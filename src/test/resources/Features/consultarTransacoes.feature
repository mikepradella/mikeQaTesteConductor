# language: pt
Funcionalidade: login Usuario 

	Usuario podera inclui logar no sistema com usuario valido, cadastrar cliente
	
	pré-requesitos: possuir um usuario valido e preencher os campos obrigatorios 


Contexto: Como um usuário válido, posso logar no sistema
	Dado que estou logado como Admin
    Quando digitar "admin" e "admin" válidas
    E clica no botão login
    Então devera acessar a Home do sistema    

@consultarTransacoes
Esquema do Cenário: Consultar cadastrado no sistema
    E clicar em QA
    E clicar em transacoes
    E clicar em Listar
    Então devera acessar a tela "Listar Transações"
    E Preencher "<nome>" 
    E clicar em pesquisar
    Entao devera ser apresentado usuario consultado  
Exemplos:
|nome			|
|mike automacao	|