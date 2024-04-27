package testdata;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class NewTest {
	public WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.id("email")).sendKeys("gani@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ganesh123");
		driver.findElement(By.name("send")).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
		driver.manage().window().maximize();
	}

}
