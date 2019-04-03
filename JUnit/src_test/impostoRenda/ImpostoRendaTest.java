package impostoRenda;
package banco;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import param.CalculoImpostoRenda;

@RunWith(Parameterized.class)
public class testeImpostoRenda {
	
	@Parameter(0)
	public double esperado;
	
	@Parameter(1)
	public double entrada;
	
	@Parameters
	public static Object[][] data(){
		return new Object[][] {
			{1321.1, 1201.0},
			{5500.0, 5000.0},
			{2750.0, 2500.0},
			{8625.0, 7500.0},
			{1000.0, 1000.0},
			{5751.15, 5001.0},
			{11500.0, 10000.0},
			{12001.2, 10001.1}
		};
	}
	 	
	@Test
	public void test() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(entrada), 0.9);
	}
}
