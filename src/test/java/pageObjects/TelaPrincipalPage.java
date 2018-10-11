package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.MetodoEspera;

/**
 * @author t-mike.pradella
 *
 */
public class TelaPrincipalPage {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > a > span")
	@CacheLookup
	public WebElement qa;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(1) > a > span")
	@CacheLookup
	public WebElement clientes;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a > span")
	@CacheLookup
	public WebElement incluirCliente;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a > span")
	@CacheLookup
	public WebElement listarCliente;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(2) > a > span")
	@CacheLookup
	public WebElement transacoes;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(2) > ul > li:nth-child(1) > a > span")
	@CacheLookup
	public WebElement incluirTransacoes;

	@FindBy(css = "#left-panel > nav > ul:nth-child(2) > li > ul > li:nth-child(2) > ul > li:nth-child(2) > a > span")
	@CacheLookup
	public WebElement listartransacoes;

	@FindBy(id = "botaoSalvar")
	@CacheLookup
	public WebElement botaoSalvar;
	
	@FindBy(css = "#content > div > div.row > div > h1 > label")
	@CacheLookup
	public WebElement validaIncluir;
	

	@FindBy(css = "	#content > div > div.row > div > h1")
	@CacheLookup
	public WebElement validaListar;
	
	@FindBy(css = "#content > div > div.row > div > h1 > label")
	@CacheLookup
	public WebElement validaIncluirTransacao;
	

	@FindBy(css = "	#content > div > div.row > div > h1")
	@CacheLookup
	public WebElement validaListarTransacao;
	
	

	// fim mapeamento de campos
	public TelaPrincipalPage(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	public void clicarQA() {
		try {
			qa.click();
			CapturaTela.capturaTela("clique em botao qa com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao qa");
			throw new RuntimeException(e);
		}
	}

	public void clicarClientes() {
		try {
			clientes.click();
			CapturaTela.capturaTela("clique em botao clientes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao clientes");
			throw new RuntimeException(e);
		}
	}
	

	public void clicarIncluirClientes() {
		try {
			incluirCliente.click();
			CapturaTela.capturaTela("clique em botao incluir clientes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao incluir clientes");
			throw new RuntimeException(e);
		}
	}

	

	public void clicarListar() {
		try {
			listarCliente.click();
			CapturaTela.capturaTela("clique em botao listar clientes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao listar clientes");
			throw new RuntimeException(e);
		}
	}
	
	public void clicarTransacoes() {
		try {
			transacoes.click();
			CapturaTela.capturaTela("clique em botao trasacoes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao transacoes");
			throw new RuntimeException(e);
		}
	}
	

	public void clicarIncluirTransacoes() {
		try {
			incluirTransacoes.click();
			CapturaTela.capturaTela("clique em botao incluir transacoes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao transacoesclientes");
			throw new RuntimeException(e);
		}
	}

	

	public void clicarListarTransacoes() {
		try {
			listartransacoes.click();
			CapturaTela.capturaTela("clique em botao listar transacoes com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao listar transacoes");
			throw new RuntimeException(e);
		}
	}

		
	public void clicarSalvar() {
		try {
			botaoSalvar.click();
			CapturaTela.capturaTela("clique em botao Salvar com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em botao Salvar");
			throw new RuntimeException(e);
		}
	}

	

	public void validaIncluir() {
		try {
			validaIncluir.isDisplayed();
			String valida = validaIncluir.getText();
			assertTrue(valida.contains("Incluir Cliente"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro de Sinistro");
			throw new RuntimeException(e);
		}
	}
	
	public void validaListar() {
		try {
			validaListar.isDisplayed();
			String valida = validaListar.getText();
			assertTrue(valida.contains("Listar Clientes"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro de Sinistro");
			throw new RuntimeException(e);
		}
	}
	
	public void validaIncluirTransacao() {
		try {
			validaIncluirTransacao.isDisplayed();
			String valida = validaIncluirTransacao.getText();
			assertTrue(valida.contains("Incluir Transacao"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro de Sinistro");
			throw new RuntimeException(e);
		}
	}
		  
	public void validaListarTransacao() {
		try {
			validaListarTransacao.isDisplayed();
			String valida = validaListarTransacao.getText();
			assertTrue(valida.contains("Listar Transações"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro de Sinistro");
			throw new RuntimeException(e);
		}
	}
	
	
	
}
