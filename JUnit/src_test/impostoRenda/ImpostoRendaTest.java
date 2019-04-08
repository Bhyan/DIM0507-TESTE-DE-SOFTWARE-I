package impostoRenda;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import param.CalculoImpostoRenda;
import param.ValorMenorZero;

@RunWith(Parameterized.class)
public class ImpostoRendaTest {
	
	@Parameter(0)
	public double entrada;
	
	@Parameter(1)
	public double esperado;
	
	@Parameters
	public static Object[][] data(){
		return new Object[][] {
			{0, 0.0},
			{0.1, 0.1},
			{1199.9, 1199.9},
			{1200.0, 1200.0},
			{1200.1, 1320.11},
			{4999.9, 5499.89},
			{5000.0, 5500.0},
			{5000.1, 5750.115},
			{9999.9, 11499.885},
			{10000.0, 11500.0},
			{10000.1, 12000.12},
			{12000.0, 14400.0}
		};
	}

	@Test(expected = ValorMenorZero.class)
	public void testeValorMenorZero() {
		CalculoImpostoRenda.calculaImposto(-1);
	}

	@Test
	public void test() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(entrada), 0.1);
	}
}
