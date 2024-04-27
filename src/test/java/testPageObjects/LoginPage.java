package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver d) {
		driver=d;
		
	}
	By LoginId=By.linkText("Login");
	By mail = By.id("username");
	By Proceed = By.id("proceed");
	By passwd=By.id("loginpassword");
	By submit = By.xpath("//*[@id=\"loginSubmit\"]");
	By alert=By.xpath("/html/body/div[6]/div/div[6]/button[1]");
	By lgot=By.id("userDropdown");
	By mypfle=By.linkText("Logout");
	
	public void Loginclick() {
		driver.findElement(LoginId).click();
	}
	public void email(String name) {
		driver.findElement(mail).sendKeys(name);
	}
	public void proceedclick() {
		driver.findElement(Proceed).click();
	}
	public void password(String name) {
		driver.findElement(passwd).sendKeys(name);
	}
	
	public void submitclick() {
		driver.findElement(submit).click();
	}
	public void clickonalert() {
		driver.findElement(alert).click();
	}
	public void logout() {
		driver.findElement(lgot).click();
	}
	public void clickonLogout() {
		driver.findElement(mypfle).click();
	}
}
