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
public class TelaHome {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#login-form > fieldset > section:nth-child(1) > label.input > input[type=\"text\"]")
	@CacheLookup
	public WebElement login;

	@FindBy(css = "#login-form > fieldset > section:nth-child(2) > label.input > input[type=\"password\"]")
	@CacheLookup
	public WebElement senha;

	

	@FindBy(css = "#login-form > footer > button")
	@CacheLookup
	public WebElement botaoSignIn;


	@FindBy(css = "#content > div > div.row > div > h1")
	@CacheLookup
	public WebElement validaTitulo;

	
	
	

    
	// fim mapeamento de campos
	public TelaHome(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	public void preencherUsuario(String usuario) {
		try {
			login.sendKeys(usuario);
			CapturaTela.capturaTela("login usuario");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao preencher usuario");
			throw new RuntimeException(e);
		}
	}
	
	public void preencherSenha(String senha1) {
		try {
			senha.sendKeys(senha1);
			CapturaTela.capturaTela("login usuario");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao preencher usuario");
			throw new RuntimeException(e);
		}
	}
	public void clicarSigIn() {
		
			
		try {
			botaoSignIn.click();
			CapturaTela.capturaTela("login usuario");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao preencher usuario");
			throw new RuntimeException(e);
		}
	}
	
	public void validaTexto	() {
		try {
			validaTitulo.isDisplayed();
			String valida = validaTitulo.getText();
			assertTrue(valida.contains("Bem vindo ao Desafio"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro de Sinistro");
			throw new RuntimeException(e);
		}
	}
		  
	
	
	
	
}
