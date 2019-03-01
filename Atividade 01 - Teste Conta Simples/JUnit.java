import junit.framework.*;

public class JUnit extends TestCase{

	ContaSimples conta;
	
	public void setUp() {
		conta = new ContaSimples("01", 50);
	}
	
	public void testCreditar() {
		conta.creditar(50);
		assertEquals(100, conta.getSaldo());
	}
	
	public void testDebita() {
		conta.debitar(45);
		assertEquals(5, conta.getSaldo());
	}
	
	public void testTransferir() {
		ContaSimples conta02 = new ContaSimples("02", 0);
		
		conta.transferir(conta02, 50);
		assertEquals(0, conta.getSaldo());
		assertEquals(50, conta02.getSaldo());
	}
}
