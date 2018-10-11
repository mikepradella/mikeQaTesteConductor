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
public class CriarTransacaoPage {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(id = "cliente")
	@CacheLookup
	public WebElement clienteCombo;
	
	
	
	@FindBy(id = "valorTransacao")
	@CacheLookup
	public WebElement valorTransacao;
	
//	

	@FindBy(id= "botaoSalvar")
	@CacheLookup
	public WebElement botaoSalvar;
	
	@FindBy(css = "#alertMessage > strong")
	@CacheLookup
	public WebElement validaIncluirTransacao;
	
	
	
	
	// fim mapeamento de campos
	public CriarTransacaoPage(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}



	

		public void selecionaCliente(String cliente) {
			try {
				
				FuncionalidadeUteis.selecionarOpcaoDropDrownPorTexto(clienteCombo, cliente);
				CapturaTela.capturaTela("combo selecionado ");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao selecionar combo");
				throw new RuntimeException(e);
			}
		}
		
		public void preencherValor(String valor) {
			try {
				valorTransacao.sendKeys(valor);
				CapturaTela.capturaTela("valor preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher valor");
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
		
		
		public void validaIncluirTransacao(String msg1) {
			try {
				validaIncluirTransacao.isDisplayed();
				String valida = validaIncluirTransacao.getText();
				assertTrue(valida.contains(msg1));
				CapturaTela.capturaTela("validacao registro com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro na validacao registro de Sinistro");
				throw new RuntimeException(e);
			}
		}
		


	
	
}
