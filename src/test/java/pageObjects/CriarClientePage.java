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
public class CriarClientePage {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(id = "nome")
	@CacheLookup
	public WebElement nome;
	
	
	
	@FindBy(id = "cpf")
	@CacheLookup
	public WebElement cpf;
	
				   	
	@FindBy(id= "status")
	@CacheLookup
	public WebElement status;
	

	
	@FindBy(id= "saldoCliente")
	@CacheLookup
	public WebElement saldoCliente;
	

	@FindBy(id= "botaoSalvar")
	@CacheLookup
	public WebElement botaoSalvar;
	
	@FindBy(css = "#alertMessage > strong")
	@CacheLookup
	public WebElement validaIncluirClientes;
	
	
	
	
	// fim mapeamento de campos
	public CriarClientePage(WebDriver driver) {
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
		
		public void preencherCPF(String cpf1) {
			try {
				cpf.click();
				cpf.sendKeys(cpf1);
				CapturaTela.capturaTela("cpf preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher cpf");
				throw new RuntimeException(e);
			}
		}
		
		public void preencherAtivo(String ativo1) {
			try {
				FuncionalidadeUteis.selecionarOpcaoDropDrownPorTexto(status, ativo1);
				CapturaTela.capturaTela("email preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher Email");
				throw new RuntimeException(e);
			}
		}
		
		public void preencherSaldo(String saldo) {
			try {
				
				saldoCliente.sendKeys(saldo);
				CapturaTela.capturaTela("saldo preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher saldo");
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
		
		
		public void validaIncluirCliente(String msg1) {
			try {
				validaIncluirClientes.isDisplayed();
				String valida = validaIncluirClientes.getText();
				assertTrue(valida.contains(msg1));
				CapturaTela.capturaTela("validacao registro com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro na validacao registro de Sinistro");
				throw new RuntimeException(e);
			}
		}
		


	
	
}
