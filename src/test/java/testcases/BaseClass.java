package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import testutilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	ReadConfig read = new ReadConfig();
	public String baseurl = read.geturl();
	public String username = read.getusername();
	public String password = read.paswrd();

	public static Logger logg;

	@BeforeTest
	public void setup() {
		logg = Logger.getLogger("cart");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", read.chrome());
		driver = new ChromeDriver();

	}

	/*
	 * @AfterClass public void teaeDown() { driver.quit(); }
	 */

	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + timestamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

}
