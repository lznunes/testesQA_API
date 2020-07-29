# language: pt
Funcionalidade: Avaliação - QA automatizado BrasilPrev

	Cenario: Procurar pessoa pelo DDD e telefone existente
		Dado Informacao de DDD e Telefene
		Quando Chama metodo GET
		Entao Retorna status sucesso 200
		E Exibe retorno