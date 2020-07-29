# language: pt
Funcionalidade: Avaliação - QA automatizado BrasilPrev
		
	Cenario: Salvar duas pessoas com o mesmo CPF
		Dado Informa dados com CPF ja cadastrado
		Quando Chama metodo POST
		Entao Retorna status erro 400
		E Exibe retorno