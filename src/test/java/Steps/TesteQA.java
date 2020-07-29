package Steps;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.runner.RunWith;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class TesteQA {
	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;
	private String url = "http://localhost:8080/pessoas/";
	private String ddd;
	private String fone;
	
	
	@Dado("Informa dados")
	public void informa_dados() {
		request = given();	
		request.header("Content-Type", "application/json");
		request.body("{\"codigo\": 0,\"nome\": \"Rafael Teixeira\", \"cpf\": \"35357122890\", \"enderecos\": [ {\"logradouro\": \"Rua Alexandre Dumas\",\"numero\": 123, \"complemento\":\"Empresa\", \"bairro\": \"Chacara Santo Antonio\", \"cidade\": \"São Paulo\",\"estado\": \"SP\" }],\"telefones\": [{\"ddd\": \"11\",\"numero\": \"985388899\" }]}");
	}
	
	@Dado("Informa dados com telefone ja cadastrado")
	public void informa_dados_com_telefone_ja_cadastrado() {
		request = given();	
		request.header("Content-Type", "application/json");
		request.body("{\"codigo\": 1,\"nome\": \"Luiz Antonio\", \"cpf\": \"12345678909\", \"enderecos\": [ {\"logradouro\": \"Rua dos Testes\",\"numero\": 24, \"complemento\":\"Empresa\", \"bairro\": \"dos QAs\", \"cidade\": \"Rio de Janeiro\",\"estado\": \"RJ\" }],\"telefones\": [{\"ddd\": \"11\",\"numero\": \"985388899\" }]}");
	}

	@Dado("Informa dados com CPF ja cadastrado")
	public void informa_dados_com_cpf_ja_cadastrado() {
		request = given();	
		request.header("Content-Type", "application/json");
		request.body("{\"codigo\": 1,\"nome\": \"Luiz Antonio\", \"cpf\": \"35357122890\", \"enderecos\": [ {\"logradouro\": \"Rua dos Testes\",\"numero\": 24, \"complemento\":\"Empresa\", \"bairro\": \"dos QAs\", \"cidade\": \"Rio de Janeiro\",\"estado\": \"RJ\" }],\"telefones\": [{\"ddd\": \"11\",\"numero\": \"955242455\" }]}");

	}
	@Dado("Informacao de DDD e Telefene")
	public void informacao_de_ddd_e_telefene() {
		ddd = "11";
		fone = "985388899";		
	}
	
	@Dado("Informacao de DDD e telefone inexistente")
	public void informacao_de_ddd_e_telefone_inexistente() {
		ddd = "11";
		fone = "976345505";
	}
	
	@Quando("Chama metodo POST")
	public void chama_api() {
		
		response = request.post(url);
	}

	@Quando("Chama metodo GET")
	public void consulta_api() {
		request = given();
		response = request.get(url + ddd + "/" + fone);
	}

	@Entao("Retorna status sucesso {int}")
	public void retorna_status(int statuscode) {
		json = response.then().statusCode(statuscode);
		
	}
	
	@Entao("Retorna status erro {int}")
	public void retorna_status_erro(int statuscode) {
		json = response.then().statusCode(statuscode);
	}
	
	@Entao("Exibe retorno")
	public void exibe_retorno_formato_json() throws IOException {
		System.out.print(response.asString());
		
	}
}
