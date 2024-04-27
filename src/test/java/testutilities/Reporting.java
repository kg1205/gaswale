package testutilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.schema.FileResourceLoader;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext testContext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname = "Test-Report" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Test-Reports/" + repname);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-configuu.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("environment", "qa");
		extent.setSystemInfo("user", "ganesh");

		htmlReporter.config().setDocumentTitle("lumacart");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("testing");

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		logger.log(Status.INFO, "passssssss");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String path = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
		File f = new File(path);
		if (f.exists()) {
			try {
				logger.fail("screenshot is" + logger.addScreenCaptureFromPath(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
