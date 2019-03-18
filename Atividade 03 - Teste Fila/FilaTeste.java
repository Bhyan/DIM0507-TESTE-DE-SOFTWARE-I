import static org.junit.Assert.*;

import org.junit.*;

public class FilaTeste {

	Fila fila;
	
	@Before
	public void setUp() {
		fila = new Fila();
	}
	
	@Test
	public void testeGetSetFim() {
		fila.setFim(5);
		assertEquals(5, fila.getFim());
	}
	
	@Test
	public void testeGetTam() {
		assertEquals(5, fila.getTam());
	}
	
	@Test
	public void testeCapacidade() {
		assertEquals(5, fila.getCapacidade());
	}
	
	@Test
	public void testeTamanho() {
		assertEquals(0, fila.tamanho());
	}
	
	@Test
	public void testeListaVaziaVerdadeiro() {
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void testeListaVaziaFalso() {
		fila.insereNaFila('1');
		assertFalse(fila.estaVazia());
	}	
	
	@Test
	public void testeInserirNaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		assertEquals(2, fila.tamanho());
	}
	
	@Test
	public void testeListaCheiaFalso() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		assertFalse(fila.estaCheia());
	}

	@Test
	public void testeListaCheiaVerdadeiro() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		fila.insereNaFila('5');
		assertTrue(fila.estaCheia());
	}

	@Test(expected = FilaCheiaException.class)
	public void testeExceptionListaCheia() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		fila.insereNaFila('5');
		fila.insereNaFila('6');
	}
	
	@Test
	public void testeRemoveDaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		assertEquals(3, fila.tamanho());
		assertEquals('1', fila.removeDaFila());
		assertEquals(2, fila.tamanho());
	}
	
	@Test(expected = FilaVaziaException.class)
	public void testeExceptionFilaVazia() {
		fila.removeDaFila();
	}

	@Test
	public void testeLimpaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		assertEquals(3, fila.tamanho());
		fila.limpaFila();
		assertEquals(0, fila.tamanho());
	}
	
	@Test(expected = FilaVaziaException.class)
	public void testeExceptionLimpaFila() {
		assertEquals(0, fila.tamanho());
		fila.limpaFila();
	}
}
