package param.temperature;

import static org.junit.Assert.*;
import org.junit.*;

public class TemperaturaTest {
	Celsius celsius;
	Fahrenheit fahrenheit;
	ConversorTemperatura conversor;
	Temperatura temperatura;
	
	@Before
	public void setUp() {
		celsius = new Celsius();
		fahrenheit = new Fahrenheit();
		conversor = new ConversorTemperatura();
	}
	
	@Test
	public void testeConvertCelsiusForFahrenheit() throws TempException {
		celsius.setValue(37);
		temperatura = conversor.converte(celsius);
		assertEquals(temperatura.getValue(), 98.6, 0.1);
	}
	
	@Test
	public void testeConvertFahrenheitForCelsius() throws TempException {
		fahrenheit.setValue(150.0);
		temperatura = conversor.converte(fahrenheit);
		assertEquals(temperatura.getValue(), 65.5, 0.1);
	}
	
	@Test(expected = TempException.class)
	public void testeTemperatureLowerZeroCelsius() throws TempException {
		celsius.setValue(-273.);
	}
	
	@Test(expected = TempException.class)
	public void testeTemperatureLowerZeroFahrenheit() throws TempException {
		fahrenheit.setValue(-459.5);
	}
}