package br.com.pathoweb.beta;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroPacienteTestPO {
	
	private static WebDriver driver;
	private static String driverPath = "/home/bryan/eclipse-workspace/chromedriver";

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void casdastrarPaciente() throws Exception {
		CadastroPaciente cadastro = new CadastroPaciente(driver);
		cadastro.cadastroPaciente();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
	}
}
