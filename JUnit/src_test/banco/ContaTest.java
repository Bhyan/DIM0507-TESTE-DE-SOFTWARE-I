package banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	Conta conta;
	
	@Before
	public void setUp() {
		conta = new Conta("01", 50);
	}
	
	@Test
	public void testCreditar() throws OperacaoIlegalException {
		conta.creditar(50);
		assertEquals(100, conta.getSaldo(), 0.1);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void testCreditarExcption() throws OperacaoIlegalException {
		conta.creditar(-50);
	}
	
	@Test
	public void testDebita() throws OperacaoIlegalException {
		conta.debitar(45);
		assertEquals(5, conta.getSaldo(), 0.1);
	}

	@Test(expected = OperacaoIlegalException.class)
	public void TesteDebitaExcption() throws OperacaoIlegalException {
		conta.debitar(-45);
	}
	
	@Test
	public void testTransferir() throws OperacaoIlegalException {
		Conta conta02 = new Conta("02", 0);
		
		conta.transferir(conta02, 50);
		assertEquals(0, conta.getSaldo(), 0.1);
		assertEquals(50, conta02.getSaldo(), 0.1);
	}
}