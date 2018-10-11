package cadastrarTransacaoStepDefiniton;

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
import pageObjects.CriarTransacaoPage;
import pageObjects.TelaHome;
import pageObjects.TelaPrincipalPage;

public class CadastrarTransacaoStepDefinition {

	public WebDriver driver;

	IniciarBrowser iniciarBrowser;
	CapturaTela capturaTela;
	TelaHome telaHome;

	NumeroRandomicos numeroRandomicos;
	FuncionalidadeUteis funcionalidadeUteis;
	TelaPrincipalPage telaPrincipalPage;
	CriarTransacaoPage criarTransacaoPage;

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
		criarTransacaoPage = new CriarTransacaoPage(driver);
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

	@Então("^clicar em transacoes$")
	public void clicar_em_transacoes() throws Throwable {
			telaPrincipalPage.clicarTransacoes();
	}

	@Então("^clicar em incluir$")
	public void clicar_em_incluir() throws Throwable {
		telaPrincipalPage.clicarIncluirTransacoes();		
	}

	@Então("^devera acessar a tela \"([^\"]*)\"$")
	public void devera_acessar_a_tela(String arg1) throws Throwable {
		telaPrincipalPage.validaIncluirTransacao();		
	}

	@Então("^seleciono o \"([^\"]*)\" ja cadastrado$")
	public void seleciono_o_ja_cadastrado(String cliente) throws Throwable {
		criarTransacaoPage.selecionaCliente(cliente);
		
	}

	@Então("^preencho o valor da \"([^\"]*)\"$")
	public void preencho_o_valor_da(String valor) throws Throwable {
		criarTransacaoPage.preencherValor(valor);
		
	}

	@Então("^clicar em Salvar$")
	public void clicar_em_Salvar() throws Throwable {
		criarTransacaoPage.clicarSalvar();
	}

	@Entao("^devera ser apresentado mensagem \"([^\"]*)\"$")
	public void devera_ser_apresentado_mensagem(String msg1) throws Throwable {
		criarTransacaoPage.validaIncluirTransacao(msg1);
		
	}

}
