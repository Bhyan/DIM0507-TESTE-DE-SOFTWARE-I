package br.com.pathoweb.beta;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CadastroPacienteTestPO.class,
	AdicionarRequisicaoTestPO.class,
	ConfigurarObrigatoriedadeTestPO.class
	})
public class SuitTestPathoWeb {}
