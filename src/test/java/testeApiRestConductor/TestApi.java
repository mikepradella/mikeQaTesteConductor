package testeApiRestConductor;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class TestApi {
	
	// Consumir API (json) de listagem de produtos.
//	valida status code se e 200 e mostra headers e content type
  @Test
    public void TesteStatusCode() {
	  RestAssured.baseURI= "http://52.191.254.38/desafio/produtos";
    	// chama o metodo get passando a url
//	   
//	    request.head("Content-type","aplication/json");
    	Response resp =RestAssured.given().header("Token", "desafio").get("");
    	// recupera o status code e salva em formato int
    	int code =resp.getStatusCode();
    	// imprimindo status code  no console
    	System.out.println("code status >  " + code);
    	System.out.println("tipo de conteudo vindo da  >> " +resp.contentType());
    	// validando se o retorno esta como esperado , neste caso 200 com sucesso
    	assertThat(code, Matchers.equalTo(200));
    	
    	
    	System.out.println();
    	System.out.println(resp.getHeaders());
    	
    	
    }
    

   // recupera os dados do url abaixo e mostra no console os dados e o tempo que de resposta
    @Test
    public void TesteBody() {
    	  RestAssured.baseURI= "http://52.191.254.38/desafio/produtos";
    	
    	Response resp =RestAssured.given().header("Token", "desafio").get("");
    	// recupera os dados e transforma em string
    	String data =resp.asString();
    	System.out.println();
    	// mostra os dados recebidos no console
    	System.out.println("Os dados da API sao : ::: " + data);
    	// recupera o tempo que resposta da requisicao
    	System.out.println("response time " +resp.getTime());
    	System.out.println();
    }
    
   
//   
   @Test
   public void BuscandoOutraForma() {
	   RestAssured.baseURI="http://52.191.254.38/desafio/produtos";
	   String response = RestAssured.given().header("Token", "desafio")
	   .when().get().then().extract().asString();
	   System.out.println("resposta novamente:  "+ response);

   }
   
   @Test
   public void TokenErrado() {
	   RestAssured.baseURI="http://52.191.254.38/desafio/produtos";	   
	   Response response = RestAssured.given().header("Toke", "desafio").get();
	   int code =response.getStatusCode();	   
	   assertThat(code, Matchers.equalTo(401));

   }
   
   
   
   @Test
   public void validaBody() {
	   RestAssured.baseURI="http://52.191.254.38/desafio/produtos";	   
	   Response response = RestAssured.given().header("Token", "desafio").get();
	   int code =response.getStatusCode();	   
	   assertThat(code, Matchers.equalTo(200));
	   response.then().body("nome", Matchers.hasItem("Chocolate"));

   }
   
   @Test
   public void ValidandoBody() {
	   RestAssured.baseURI="http://52.191.254.38/desafio/produtos";	   
	   RestAssured.given()
	   .when()
	   .header("Token", "desafio")  
	   .get()
	   .then()
	   .assertThat().log()
	   .all()
	   .statusCode(200)
	   .and()
	   .body("descricao", Matchers.hasItem("Chocolate ao leite"));
   }
   
  
 
 
    
     }
   
   