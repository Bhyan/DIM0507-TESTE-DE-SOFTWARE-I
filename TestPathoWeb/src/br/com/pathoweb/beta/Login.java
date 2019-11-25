package br.com.pathoweb.beta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	private WebDriver driver;
	private String baseUrl = "https://beta.pathoweb.com.br";

	public Login(WebDriver driver) {
		this.driver = driver;
		driver.get(baseUrl);
		PageFactory.initElements(driver, this);
	}

	public void logar(String email, String senha) {
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a")).click();
		username.click();
		username.clear();
		username.sendKeys(email);
		password.click();
		password.clear();
		password.sendKeys(senha);
		driver.findElement(By.id("loginform")).submit();
		driver.findElement(By.id("moduloexameid")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/a")).click();
	}
}