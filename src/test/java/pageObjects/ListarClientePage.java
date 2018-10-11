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
public class ListarClientePage {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#formListarCliente > div > fieldset > div > div > div.col-sm-12.col-md-6 > input")
	@CacheLookup
	public WebElement nome;
	
	@FindBy(id = "calendario_input")
	@CacheLookup
	public WebElement data;
	
	
	@FindBy(css = "#formListarCliente > div > fieldset > div > div > div.col-sm-12.col-md-1 > input")
	@CacheLookup
	public WebElement botaoPesquisar;
	
	@FindBy(css = "#formListarCliente > div > div > table > tbody > tr > td:nth-child(1)")
	@CacheLookup
	public WebElement validaPesquisa;
	
	
	
	
	// fim mapeamento de campos
	public ListarClientePage(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}



	

		public void preencherNome(String nome1) {
			try {
				
				nome.sendKeys(nome1);
				CapturaTela.capturaTela("nome preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher nome");
				throw new RuntimeException(e);
			}
		}
		
		public void preencherData(String data1) {
			try {
				data.click();
				data.sendKeys(data1);
				CapturaTela.capturaTela("nome preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher nome");
				throw new RuntimeException(e);
			}
		}
		
		
	
		public void clicarPesquisar() {
			try {
				botaoPesquisar.click();
				CapturaTela.capturaTela("clique em botao pesquisar com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro ao clicar em botao pesquisar");
				throw new RuntimeException(e);
			}
		}
		
		
		public void validaPesquisaCliente() {
			try {				
				validaPesquisa.isDisplayed();
				String valida = validaPesquisa.getText();
				assertTrue(valida.contains("mike automacao"));
				CapturaTela.capturaTela("validacao registro com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro na validacao registro de Sinistro");
				throw new RuntimeException(e);
			}
		}
		


	
	
}
