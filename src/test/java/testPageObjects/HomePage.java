package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver d) {
		driver = d;
	}

	By dashbord=By.linkText("Dashboard");
	By ActvOrds=By.id("v-pills-aorders-tab");
	By viewod=By.xpath("//*[@id=\"aorders\"]/div/div[1]/div[2]/div/a/i");
	By raisetkt=By.xpath("//a[@class='btn btn-secondary w-auto float-end mt-3']");
	By names=By.id("name1");
	By mail=By.name("email");
	By mobile=By.id("mobile1");
	By sub=By.id("subject1");
	By msg=By.id("comments1");
	By submit=By.name("submit");
	By reorde=By.xpath("//*[@id=\"aorders\"]/div/div[1]/div[2]/div/i[1]");
	By aleert=By.xpath("//button[@class='swal2-confirm swal2-styled']");
	public void Dashboard() {
		driver.findElement(dashbord).click();
	}
	public void ActiveOrders() {
		driver.findElement(ActvOrds).click();
		
	}
	public void ViewOrder() {
		driver.findElement(viewod).click();
	}
	public void reorder() {
		driver.findElement(reorde).click();
	}
	
	public void RaiseTicket(){
		driver.findElement(raisetkt).click();
	}
	public void namebox(String name){
		driver.findElement(names).sendKeys(name);
	}
	public void mailid(String name){
		driver.findElement(mail).sendKeys(name);
	}
	public void mobileno(String name){
		driver.findElement(mobile).sendKeys(name);
	}
	public void subject(String name){
		driver.findElement(sub).sendKeys(name);
	}
	public void message(String name) {
		driver.findElement(msg).sendKeys(name);
	}
	public void submitclick() {
		driver.findElement(submit).click();
	}
}
