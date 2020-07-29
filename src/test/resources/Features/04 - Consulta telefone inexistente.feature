# language: pt
Funcionalidade: Avaliação - QA automatizado BrasilPrev

	Cenario: Busca pessoa por telefone inexistente
		Dado Informacao de DDD e telefone inexistente
		Quando Chama metodo GET
		Entao Retorna status erro 404
		E Exibe retorno
