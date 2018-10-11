package loginConductorStepDefiniton;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.IniciarBrowser;
import funcionalidadesUtils.NumeroRandomicos;
import pageObjects.TelaHome;

public class LoginConductorStepDefinition {

	public WebDriver driver;

	IniciarBrowser iniciarBrowser;
	CapturaTela capturaTela;
	TelaHome telaHome;

	
	NumeroRandomicos numeroRandomicos;
	FuncionalidadeUteis funcionalidadeUteis;
	
	
	public void setUp() throws InterruptedException {
		System.out.println("Navegador iniciado");
		iniciarBrowser = new IniciarBrowser();
		// posso iniciar por aqui ou utilizando arquivo de propriedade, estou usando o
		// arquivo propriedade
		WebDriver driver = iniciarBrowser.startBrowser("CHROME", "https://www.google.com.br");
		this.driver = driver;
		numeroRandomicos = new NumeroRandomicos();
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		telaHome = new TelaHome(driver);
	}

	@After
	public void setUpFinal() {
		iniciarBrowser.fecharNavegadores();
	}
	
	@Dado("^que estou logado como Admin$")
	public void que_estou_logado_como_Admin() throws Throwable {
		this.setUp();
	  
	}

	@Quando("^digitar \"([^\"]*)\" e \"([^\"]*)\" válidas$")
	public void digitar_e_válidas(String usuario, String senha) throws Throwable {
	  telaHome.preencherUsuario(usuario);
	  telaHome.preencherSenha(senha);
	  	}

	@Quando("^clica no botão login$")
	public void clica_no_botão_login() throws Throwable {
	  telaHome.clicarSigIn();
	  
	}

	@Então("^devera acessar a Home do sistema$")
	public void devera_acessar_a_Home_do_sistema() throws Throwable {
	  telaHome.validaTexto();
	}


}
