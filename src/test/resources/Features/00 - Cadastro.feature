# language: pt
Funcionalidade: Avaliação - QA automatizado BrasilPrev

	Cenario: Salvar nova pessoa no sistema
		Dado Informa dados
		Quando Chama metodo POST
		Entao Retorna status sucesso 201
		Entao Exibe retorno