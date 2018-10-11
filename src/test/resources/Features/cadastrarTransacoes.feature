# language: pt
Funcionalidade: login Usuario 

	Usuario podera logar no sistema com usuario valido, inclui transacoes 
	
	pré-requesitos: possuir um usuario valido e ter um usuario ja cadastrado, valor da transaçao
	Para realizar uma venda, apenas deverá ser permitido caso o saldo do cliente for igual ou superior ao valor da compra.


Contexto: Como um usuário válido, posso logar no sistema
	Dado que estou logado como Admin
    Quando digitar "admin" e "admin" válidas
    E clica no botão login
    Então devera acessar a Home do sistema    

@cadastrarTransacoes
Esquema do Cenário: Cadastrar transacoes no sistema
    E clicar em QA
    E clicar em transacoes
    E clicar em incluir
    Então devera acessar a tela "Incluir Transacao"
    E seleciono o "<cliente>" ja cadastrado
    E preencho o valor da "<valor transacao>"
    E clicar em Salvar
    Entao devera ser apresentado mensagem "Venda realizada com sucesso"    
Exemplos:
|cliente			|valor transacao|
|mike automacao		|10				|


@travarBotoes
Cenário: Validar bloqueio de botoes
    E clicar em QA
    E clicar em transacoes
    E clicar em incluir
    Então devera acessar a tela "Incluir Transacao"
    Entao o sistema nao devera apresentar botao salvar liberado
    
@cadastrarTransacoes
Esquema do Cenário: Cadastrar transacoes  superior ao saldo do cliente
    E clicar em QA
    E clicar em transacoes
    E clicar em incluir
    Então devera acessar a tela "Incluir Transacao"
    E seleciono o "<cliente>" ja cadastrado
    E preencho o valor superior ao saldo do cliente "<valor transacao>"
    E clicar em Salvar
    Entao sistema devera bloquear a transacao e avisar com uma "<mensagem>"
    |cliente			|valor transacao|mensagem|
	|mike automacao		|10				|        | 
    
    
    
    
    
    
    
    