# language: pt
Funcionalidade: Avaliação - QA automatizado BrasilPrev
		
	Cenario: Salvar duas pessoas com o mesmo telefone
		Dado Informa dados com telefone ja cadastrado
		Quando Chama metodo POST
		Entao Retorna status erro 400
		E Exibe retorno