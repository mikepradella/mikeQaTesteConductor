package consultarClienteStepDefiniton;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.IniciarBrowser;
import funcionalidadesUtils.NumeroRandomicos;
import pageObjects.CriarClientePage;
import pageObjects.ListarClientePage;
import pageObjects.TelaHome;
import pageObjects.TelaPrincipalPage;

public class ConsultarClienteStepDefinition {

	public WebDriver driver;

	IniciarBrowser iniciarBrowser;
	CapturaTela capturaTela;
	TelaHome telaHome;

	NumeroRandomicos numeroRandomicos;
	FuncionalidadeUteis funcionalidadeUteis;
	TelaPrincipalPage telaPrincipalPage;
	ListarClientePage listarClientePage;

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
		listarClientePage  = new ListarClientePage(driver);

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

	@Dado("^clicar em QA$")
	public void clicar_em_QA() throws Throwable {
		telaPrincipalPage.clicarQA();
	}

	@Dado("^clicar em cliente$")
	public void clicar_em_cliente() throws Throwable {
		telaPrincipalPage.clicarClientes();
	}

	@Então("^clicar em Listar$")
	public void clicar_em_Listar() throws Throwable {
		telaPrincipalPage.clicarListar();
	}

	@Então("^devera acessar a tela \"([^\"]*)\"$")
	public void devera_acessar_a_tela(String msg) throws Throwable {
		telaPrincipalPage.validaListar();
	}

	@Então("^Preencher \"([^\"]*)\" , \"([^\"]*)\"$")
	public void preencher(String nome, String data) throws Throwable {
		listarClientePage.preencherNome(nome);
		listarClientePage.preencherData(data);
	}


	@Então("^clicar em pesquisar$")
	public void clicar_em_pesquisar() throws Throwable {
		listarClientePage.clicarPesquisar();
	}

	@Entao("^devera ser apresentado usuario consultado$")
	public void devera_ser_apresentado_usuario_consultado() throws Throwable {
		listarClientePage.validaPesquisaCliente();
	}

}
