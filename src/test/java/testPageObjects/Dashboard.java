package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver d) {
		driver = d;
	}
	By DashBD=By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a");
	By Select_id=By.id("select_id");
	By VIew_OD=By.xpath("//*[@id=\"aorders\"]/div/div[1]/div[2]/div/a/i");
	//By od=By.xpath("//*[@id=\"PCH005\"]/div/div[2]/div/div/p[2]");
	
	
	
	public void ClickOnDashboard() {
		driver.findElement(DashBD).click();
	}
	public void Selectid() {
		driver.findElement(Select_id).click();
		
	}
	public void ViewOrd() {
		driver.findElement(VIew_OD).click();
	}
	

	
}
