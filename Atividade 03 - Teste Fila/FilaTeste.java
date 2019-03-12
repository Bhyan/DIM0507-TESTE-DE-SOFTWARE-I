package fila;

import static org.junit.Assert.*;

import org.junit.*;

public class FilaTeste {

	Fila fila;
	
	@Before
	public void setUp() {
		fila = new Fila();
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
		assertEquals(-1, fila.tamanho());
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
	
	/*
	 * Com o método tamanho retorna a variável fim, que guarda o índice da fila 
	 * é o método getTam retorna o tamanho máximo da fila, o jeito mais confiável 
	 * de testar e utilizando o método removeDaFila, pois ele retorna o primeiro 
	 * índice, que foi removido da fila. 
	 */
	@Test
	public void testeInserirNaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		assertEquals('1', fila.removeDaFila());
	}
	
	@Test
	public void testeListaCheiaFalso() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		assertFalse(fila.estaCheia());
	}

	/*
	 * O teste está passando, porém o código da função está errado, pois na 
	 * função listaCheia compara a variável fim, que é o valor de indexação,
	 * com a variável tamanho, que é o tamanho da lista. Esses dois valores nunca
	 * vão ser iguais.
	 */
	@Test
	public void testeListaCheiaVerdadeiro() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		fila.insereNaFila('5');
		fila.setFim(5);
		assertTrue(fila.estaCheia());
	}
	
	/*
	 * Como a função removeDaFila só sobrescrever o valor da fila, e não altera seu
	 * tamanho, foi usada a função seguida vezes, para mostrar que o próximo valor 
	 * removido era diferente do anterior.
	 */
	@Test
	public void testeRemoveDaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		assertEquals('1', fila.removeDaFila());
		assertEquals('2', fila.removeDaFila());
	}
	
	@Test
	public void testeLimpaFila() {
		fila.insereNaFila('1');
		fila.insereNaFila('2');
		fila.insereNaFila('3');
		fila.insereNaFila('4');
		fila.insereNaFila('5');
		fila.limpaFila();
		assertEquals(-1, fila.getFim());
	}
}
