package cadastrarClienteStepDefiniton;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.IniciarBrowser;
import funcionalidadesUtils.NumeroRandomicos;
import pageObjects.CriarClientePage;
import pageObjects.TelaHome;
import pageObjects.TelaPrincipalPage;


public class CadastrarClienteStepDefinition {

	public WebDriver driver;

	IniciarBrowser iniciarBrowser;
	CapturaTela capturaTela;
	TelaHome telaHome;
	CriarClientePage criarClientePage;

	NumeroRandomicos numeroRandomicos;
	FuncionalidadeUteis funcionalidadeUteis;
	TelaPrincipalPage telaPrincipalPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.out.println("Navegador iniciado");
		iniciarBrowser = new IniciarBrowser();
		// posso iniciar por aqui ou utilizando arquivo de propriedade, estou usando o
		// arquivo propriedade
		WebDriver driver = iniciarBrowser.startBrowser("CHROME", "https://www.google.com.br");
		this.driver = driver;
		telaPrincipalPage = new TelaPrincipalPage(driver);
		numeroRandomicos = new NumeroRandomicos();
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		telaHome = new TelaHome(driver);
		criarClientePage = new CriarClientePage(driver);
	   	
	}
	
	@AfterTest
	public void setUpFinal() {
		iniciarBrowser.fecharNavegadores();
	}
	
	@Dado("^que estou logado como Admin$")
	public void que_estou_logado_como_Admin() throws Throwable {
		setUp();
	  
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


	@Dado("^clicar em QA$")
	public void clicar_em_QA() throws Throwable {
		telaPrincipalPage.clicarQA();
	}

	@Dado("^clicar em cliente$")
	public void clicar_em_cliente() throws Throwable {
		telaPrincipalPage.clicarClientes();		
	}

	@Dado("^clicar em incluir$")
	public void clicar_em_incluir() throws Throwable {
		telaPrincipalPage.clicarIncluirClientes();
	}

	@Então("^devera acessar a tela \"([^\"]*)\"$")
	public void devera_acessar_a_tela(String arg1) throws Throwable {
		telaPrincipalPage.validaIncluir();		
	}

	@Então("^Preencher \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void preencher(String nome, String cpf, String status, String saldo) throws Throwable {
		criarClientePage.preencherNome(nome);
		criarClientePage.preencherCPF(cpf);
		criarClientePage.preencherAtivo(status);
		criarClientePage.preencherSaldo(saldo);
	}

	@Então("^clicar em Salvar$")
	public void clicar_em_Salvar() throws Throwable {
		criarClientePage.clicarSalvar();		
	}

	@Entao("^devera ser apresentado mensagem \"([^\"]*)\"$")
	public void devera_ser_apresentado_mensagem(String msg) throws Throwable {
		criarClientePage.validaIncluirCliente(msg);
		
	}

}
