# language: pt
Funcionalidade: login Usuario 

	Usuario podera inclui logar no sistema com usuario valido
	
	pré-requesitos: possuir um usuario valido 


Contexto: 
    Dado que estou logado como Admin
@loginValido
Esquema do Cenário: Como um usuário válido, posso logar no sistema
    Quando digitar "<usuario>" e "<senha>" válidas
    E clica no botão login
    Então devera acessar a Home do sistema    
Exemplos:
|usuario			|senha  |
|admin		 		|admin	|