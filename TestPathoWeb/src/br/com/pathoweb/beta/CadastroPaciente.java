package br.com.pathoweb.beta;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CadastroPaciente {

	private WebDriver driver;

	@FindBy(id = "nome")
	private WebElement nome;

	@FindBy(id = "rg")
	private WebElement rg;

	@FindBy(id = "cpf")
	private WebElement cpf;

	@FindBy(id = "sexo")
	private WebElement sexo;

	@FindBy(id = "estadoCivil")
	private WebElement estadoCivil;

	@FindBy(linkText = "Próximo")
	private WebElement proximo;

	public CadastroPaciente(WebDriver driver) throws IOException {
		this.driver = driver;
		FileReader file = new FileReader("./src/br/com/pathoweb/beta/login.properties");
		Properties userAndPassword = new Properties();
		userAndPassword.load(file);
		PageFactory.initElements(driver, this);

		Login login = new Login(driver);
		String email = userAndPassword.getProperty("user");
		String senha = userAndPassword.getProperty("password");

		login.logar(email, senha);
	}

	public void cadastroPaciente() {
		driver.findElement(By.linkText("Criar novo exame")).click();
		driver.findElement(By.xpath("//*[@id=\"modalSiglaExame\"]/div/div/div[3]/a")).click();
		driver.findElement(By.cssSelector("#consultarPaciente > svg.svg-inline--fa.fa-search.fa-w-16")).click();
		driver.findElement(By.xpath("//*[@id=\"criarPaciente\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user_e\"]/tbody/tr[2]/td[3]/a")).click();
		nome.clear();
		nome.sendKeys("Francisco");
		driver.findElement(By.xpath("//*[@id=\"user_e\"]/tbody/tr[4]/td[3]/a")).click();
		rg.clear();
		rg.sendKeys("5555555555");
		driver.findElement(By.xpath("//*[@id=\"user_e\"]/tbody/tr[6]/td[3]/a")).click();
		cpf.clear();
		cpf.sendKeys("23660283002");
		driver.findElement(By.xpath("//*[@id=\"user_e\"]/tbody/tr[7]/td[3]/a")).click();
		new Select(driver.findElement(By.id("sexo"))).selectByVisibleText("Masculino");
		sexo.click();
		driver.findElement(By.xpath("//*[@id=\"user_e\"]/tbody/tr[8]/td[3]/a")).click();
		new Select(driver.findElement(By.id("estadoCivil"))).selectByVisibleText("Casado");
		estadoCivil.click();
		proximo.click();
	}
}
