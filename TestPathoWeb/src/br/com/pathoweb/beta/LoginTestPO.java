package br.com.pathoweb.beta;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestPO {
	private static WebDriver driver;
	private static String driverPath = "/home/bryan/eclipse-workspace/chromedriver";

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void testeLogin() throws Exception {	
		FileReader file = new FileReader("./src/br/com/pathoweb/beta/login.properties");
		Properties userAndPassword = new Properties();
		userAndPassword.load(file);
		
		Login login = new Login(driver);
		String email = userAndPassword.getProperty("user");
		String senha = userAndPassword.getProperty("password");
				
		login.logar(email, senha);
	}

//	@AfterClass
//	public static void tearDown() throws Exception {
//		driver.close();
//	}
}