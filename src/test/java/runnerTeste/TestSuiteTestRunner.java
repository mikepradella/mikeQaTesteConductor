 package runnerTeste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import loginConductorStepDefiniton.LoginConductorStepDefinition;

@RunWith(Suite.class)
@Suite.SuiteClasses({

	CadastrarClienteRunner.class,
	ConsultaClienteRunner.class,
	CadastrarTransacoesRunner.class,
	ConsultaTransacoesRunner.class,

})
public class TestSuiteTestRunner{	
	

}
	
	