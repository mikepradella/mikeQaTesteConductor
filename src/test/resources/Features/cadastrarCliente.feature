# language: pt
Funcionalidade: login Usuario 

	Usuario podera inclui logar no sistema com usuario valido, cadastrar cliente
	
	pré-requesitos: possuir um usuario valido e preencher os campos obrigatorios 


Contexto: Como um usuário válido, posso logar no sistema
	Dado que estou logado como Admin
    Quando digitar "admin" e "admin" válidas
    E clica no botão login
    Então devera acessar a Home do sistema    

@cadastrarCliente
Esquema do Cenário: Cadastrar cliente no sistema
    E clicar em QA
    E clicar em cliente
    E clicar em incluir
    Então devera acessar a tela "Incluir Cliente"
    E Preencher "<nome>" , "<cpf>" , "<ativo>" , "<saldo>"
    E clicar em Salvar
    Entao devera ser apresentado mensagem "Cliente salvo com sucesso"    
Exemplos:
|nome			|cpf			|ativo|saldo|
|mike automacao	|37520451936	|Ativo|10000|


@validaObrigatorios
Cenário: Validar campos Obrigatorios
    E clicar em QA
    E clicar em cliente
    E clicar em incluir
    Então devera acessar a tela "Incluir Cliente"
    E clicar em salvar
    Entao sistema devera apresenta mensagem a todos os campos que sao obrigatorios
    
@validaNaoObrigatorios
Cenário: Validar Inclusao sem preenchimento obrigatorios
    E clicar em QA
    E clicar em cliente
    E clicar em incluir
    Então devera acessar a tela "Incluir Cliente"
    E Preencher "<nome>" , "<cpf>" 
    Entao sistema  nao devera incluir Cliente e retornar com mensagem dos campos faltantes