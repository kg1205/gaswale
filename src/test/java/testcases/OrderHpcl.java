package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderHpcl {
	WebDriver driver;

	public OrderHpcl(WebDriver d) {
		driver = d;
	}
	By Hpcl=By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/a/img");
	By Addcart=By.xpath("//*[@id=\"products\"]/div[1]/div/div[4]/div[2]/div/button");
	By GoCart=By.xpath("//*[@id=\"navbarNav\"]/ul/li[9]");
	By returncyl=By.id("returnCount");
	By Schedule=By.name("orderdate");
	By date=By.name("scheduledDate");
	By time=By.name("scheduletime");
	By proceed=By.id("proceed");
	By shpadress=By.id("addAddress");
	By addars=By.xpath("//*[@id=\"createAddress\"]/div/div[11]/button");
	
	public void ClickHpcl() {
		driver.findElement(Hpcl).click();
	}
	public void ClickOnAddCart() {
		driver.findElement(Addcart).click();
	}
	public void GoToCart() {
		driver.findElement(GoCart).click();
	}
	public void RetirnCyldr() {
		Select s=new Select(driver.findElement(returncyl));
		s.selectByIndex(2);
	}
	public void ScheduleOrder() {
		driver.findElement(Schedule).click();
	}
	public void ChangeDate(String name) {
		driver.findElement(date).sendKeys(name);
	}
	public void ScheduleTime() {
		Select s=new Select(driver.findElement(time));
		s.selectByIndex(2);
	}
	public void ClickonProceed() {
		driver.findElement(proceed).click();
	}
	public void ClickOnShipAdres() {
		driver.findElement(shpadress).click();
	}
	public void ClickOnAddAdres() {
		driver.findElement(addars).click();
		
	}
}
