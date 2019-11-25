package br.com.pathoweb.beta;

import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PathoWeb {
	private static WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public static void login() throws IOException {
		FileReader file = new FileReader("./src/br/com/pathoweb/beta/login.properties");
		Properties login = new Properties();
		login.load(file);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.get("https://beta.pathoweb.com.br/login/auth");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(login.getProperty("user"));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(login.getProperty("password"));
		driver.findElement(By.id("loginform")).submit();
		driver.get("https://beta.pathoweb.com.br/");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Exames'])[1]/following::h3[1]"))
				.click();
		file.close();
	}

	@Test
	public void testECadastroPaciente() throws Exception {
		driver.get("https://beta.pathoweb.com.br/moduloExame/index");
		driver.findElement(By.linkText("Pré-cadastros")).click();
		driver.findElement(By.linkText("Pacientes")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Paciente'])[1]/following::button[1]"))
				.click();
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("Francisco");
		driver.findElement(By.id("numeroPaciente")).clear();
		driver.findElement(By.id("numeroPaciente")).sendKeys("10");
		driver.findElement(By.id("rg")).clear();
		driver.findElement(By.id("rg")).sendKeys("5019650017");
		driver.findElement(By.id("passaporte")).clear();
		driver.findElement(By.id("passaporte")).sendKeys("5555555");
		driver.findElement(By.id("cpf")).clear();
		driver.findElement(By.id("cpf")).sendKeys("062.034.062-17");
		new Select(driver.findElement(By.id("sexo"))).selectByVisibleText("M");
		driver.findElement(By.id("dataNascimento")).clear();
		driver.findElement(By.id("dataNascimento")).sendKeys("1998-03-22");
		new Select(driver.findElement(By.id("estadoCivil"))).selectByVisibleText("Casado(a)");
		new Select(driver.findElement(By.id("estadoCivil"))).selectByVisibleText("Solteiro(a)");
		driver.findElement(By.id("profissao")).clear();
		driver.findElement(By.id("profissao")).sendKeys("Teste");
		driver.findElement(By.id("localTrabalho")).clear();
		driver.findElement(By.id("localTrabalho")).sendKeys("Teste");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Profissão'])[1]/following::label[1]"))
				.click();
		driver.findElement(By.id("telefone")).clear();
		driver.findElement(By.id("telefone")).sendKeys("(84) 90908-8522");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("teste@teste.com");
		driver.findElement(By.id("cep")).clear();
		driver.findElement(By.id("cep")).sendKeys("59151040");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Telefones'])[1]/following::input[1]"))
				.clear();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Telefones'])[1]/following::input[1]"))
				.sendKeys("8455555555");
		driver.findElement(By.id("pacienteLaboratorioOrigem")).clear();
		driver.findElement(By.id("pacienteLaboratorioOrigem")).sendKeys("0.01");
		new Select(driver.findElement(By.id("cor"))).selectByVisibleText("Branca");
		driver.findElement(By.id("mae")).clear();
		driver.findElement(By.id("mae")).sendKeys("Teste Mãe");
		driver.findElement(By.id("pai")).clear();
		driver.findElement(By.id("pai")).sendKeys("Teste Pai");
		new Select(driver.findElement(By.id("servicoEntrega"))).selectByVisibleText("Sim");
		driver.findElement(By.id("cns")).clear();
		driver.findElement(By.id("cns")).sendKeys("Cns");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Paciente'])[1]/following::button[1]"))
				.click();
	}

	@Test
	public void testCriarExame() throws Exception {
		driver.get("https://beta.pathoweb.com.br/moduloExame/index");
		driver.findElement(By.linkText("Criar novo exame")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fechar'])[8]/following::a[1]")).click();
	}

	@Test
	public void testVincularPaciente() throws Exception {
		driver.get("https://beta.pathoweb.com.br/moduloExame/index");
		driver.findElement(By.xpath("//*[@id=\"ulAndamento\"]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"tabelaLocalizarExamesTbody\"]/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"tootleDisplay\"]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"pacienteSearch\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"consultarPaciente\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"formPacienteId\"]/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.id("usarPacienteSelecionado")).click();
	}

	@Test
	public void testAdicionarRequisicao() throws Exception {
		driver.get("https://beta.pathoweb.com.br/moduloExame/index");
		driver.findElement(By.linkText("Próximo")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Biopsia'])[2]/following::td[3]"))
				.click();
		driver.findElement(By.linkText("MedMais")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='* Número do cartão'])[1]/following::td[1]"))
				.click();
		driver.findElement(By.id("numeroCartao")).clear();
		driver.findElement(By.id("numeroCartao")).sendKeys("6066602");
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='* Data de exp. da RG'])[1]/following::td[1]"))
				.click();
		driver.findElement(By.id("dataExpedicaoRG")).clear();
		driver.findElement(By.id("dataExpedicaoRG")).sendKeys("22/02/2008");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vazio'])[39]/following::td[3]"))
				.click();
		driver.findElement(By.linkText("CRM: PE12142 - ABELARDO ALVES")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ABELARDO ALVES'])[2]/following::td[3]"))
				.click();
		driver.findElement(By.linkText("ENDOSCOPIA")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ENDOSCOPIA'])[3]/following::a[1]"))
				.click();
	}

	@Test
	public void testConfigurarObrigatoriedade() throws Exception {
		driver.get("https://beta.pathoweb.com.br/moduloExame/index");
		driver.findElement(By.cssSelector("#requiredParametersToActivete > path")).click();
		driver.findElement(By.name("pacienteParametros")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Branca'])[2]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CPF'])[1]/following::input[2]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vazio'])[2]/following::input[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='teste@teste.com'])[1]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Endereço'])[2]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RN'])[1]/following::input[1]")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vazio'])[5]/following::input[1]"))
				.click();
		driver.findElement(By.linkText("Próximo")).click();
		driver.findElement(By.id("requiredParameters")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Convênio'])[2]/following::input[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Inf. fora do TISS'])[2]/following::input[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Serviço de Entrega'])[2]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vazio'])[24]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='AUTOMÁTICO'])[1]/following::input[1]"))
				.click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vazio'])[18]/following::input[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Intersistemas LTDA - 67085415000186'])[2]/following::input[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Dados solicitante'])[2]/following::input[1]"))
				.click();
		driver.findElement(By.id("obrigatoriedadeRequisicaoBtn")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
