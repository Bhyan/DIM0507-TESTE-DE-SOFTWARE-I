package impostoRenda;
import static org.junit.Assert.*;
import org.junit.*;

import param.CalculoImpostoRenda;

public class ImpostoRendaTest {
	
	// Teste 10% de imposto para o mínimo valor.
	@Test
	public void testCalculoImposto10Inferior() {
		assertEquals(1321.1, CalculoImpostoRenda.calculaImposto(1201), 01);
	}
	
	// Teste 10% de imposto para o maior valor.
	@Test
	public void testCalculoImposto10Superio() {
		assertEquals(5500.0, CalculoImpostoRenda.calculaImposto(5000), 01);
	}
	
	// Teste 10% de imposto para o valor central.
	@Test
	public void testCalculoImposto10Meio() {
		assertEquals(2750.0, CalculoImpostoRenda.calculaImposto(2500), 01);
	}
	
	// Teste 15% de imposto para o mínimo valor.
	@Test
	public void testCalculoImposto15Inferior() {
		assertEquals(5751.15, CalculoImpostoRenda.calculaImposto(5001), 01);
	}
	
	// Teste 15% de imposto para o maior valor.
	@Test
	public void testCalculoImposto15Superior() {
		assertEquals(11500.0, CalculoImpostoRenda.calculaImposto(10000), 01);
	}
	
	// Teste 15% de imposto para o valor central.
	@Test
	public void testCalculoImposto15Meio() {
		assertEquals(8625.0, CalculoImpostoRenda.calculaImposto(7500), 01);
	}

	// Teste sem imposto.
	@Test
	public void testCalculoImposto0() {
		assertEquals(1000.0, CalculoImpostoRenda.calculaImposto(1000), 01);
	}
	
	// Teste 20% de imposto.
	@Test
	public void testCalculoImposto20() {
		assertEquals(12001.2, CalculoImpostoRenda.calculaImposto(10001), 01);
	}
}