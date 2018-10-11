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
public class ListarTransacoesPage {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(id = "cliente")
	@CacheLookup
	public WebElement cliente;
//		
	@FindBy(css = "#formListarTransacao > div > div > fieldset:nth-child(2) > div > div > div > input")
	@CacheLookup
	public WebElement botaoPesquisar;
	
	@FindBy(css = "#formListarCliente > div > div > table > tbody > tr > td:nth-child(1)")
	@CacheLookup
	public WebElement validaPesquisa;
	
	
	
	
	// fim mapeamento de campos
	public ListarTransacoesPage(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}



	

		public void preencherCliente(String cliente1) {
			try {
				
				FuncionalidadeUteis.selecionarOpcaoDropDrownPorTexto(cliente, cliente1);
				CapturaTela.capturaTela("selecao preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro selecionar ao preencher nome");
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
		
		
		


	
	
}
