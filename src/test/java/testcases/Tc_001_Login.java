package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import freemarker.template.utility.CaptureOutput;
import junit.framework.Assert;
import testPageObjects.HomePage;
import testPageObjects.LoginPage;
import testPageObjects.Dashboard;

public class Tc_001_Login extends BaseClass {
	@Test(priority = 1)
	public void login() throws IOException, Exception {
		driver.get(baseurl);
		driver.manage().window().maximize();
		logg.info("url has opened");
		LoginPage l = new LoginPage(driver);
		// driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id=\"locationBackdrop\"]/div/div/div/div/div[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l.Loginclick();
		l.email(username);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logg.info("username entered");
		l.proceedclick();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l.password(password);
		logg.info("password has entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l.submitclick();
		logg.info("clicked the signin");
		Thread.sleep(3000);

		l.clickonalert();
		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); l.logout();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * l.clickonLogout();
		 */
	}

	@Test(enabled =false)
	public void HomePages() throws IOException {
		HomePage h = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		h.Dashboard();
		h.ActiveOrders();
		h.ViewOrder();
		String exp = "HPCL";
		String act = driver.findElement(By.xpath("//*[@id=\"PCH005\"]/div/div[2]/div/div/p[1]")).getText();

		Assert.assertEquals(exp, act);

		System.out.println("assertion passed");

		// h.reorder();

		h.RaiseTicket();

		/*
		 * h.namebox("    "); h.mailid("        "); h.mobileno("   ");
		 * h.subject("    "); h.message("   ");
		 */
		h.submitclick();

		// captureScreenshot(driver, "login");
	}

	@Test(enabled =false)
	public void Dashbd() throws IOException, Exception {
		Dashboard ds = new Dashboard(driver);
		Thread.sleep(3000);
		ds.ClickOnDashboard();
		ds.Selectid();
		ds.ViewOrd();
		String act = driver.findElement(By.xpath("//*[@id=\"PCH005\"]/div/div[2]/div/div/p[2]")).getText();
		String exp = "05 Kg LPG Refill";
		captureScreenshot(driver, "order");
		Assert.assertEquals(exp, act);
		System.out.println("assertion passed set");
		Thread.sleep(3000);
		
	}
	@Test(priority=4)
	public void Order() {
		driver.findElement(By.xpath("/html/body/nav/div/a/img")).click();
		OrderHpcl od=new OrderHpcl(driver);
		od.ClickHpcl();
		od.ClickOnAddCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		od.GoToCart();
		od.RetirnCyldr();
		od.ScheduleOrder();
		od.ChangeDate("12/30/2023");
		od.ScheduleTime();
		od.ClickonProceed();
		od.ClickOnShipAdres();
		od.ClickOnAddAdres();
		
	}
}
