package ExtentReport.learnER;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnER {
	ExtentReports extent;
    @BeforeTest
    public void config()
    {
    	//We need to class ExtentReport and 
    	//extentSparkReporter() : for creating reports, we need to give path where report file generated
    	//to create directory via command
    	String path= System.getProperty(("user.dir")+"\\reports\\index.html");
    	ExtentHtmlReporter sr=new ExtentHtmlReporter(path);
    	sr.config().setReportName("My First Report");
    	sr.config().setDocumentTitle("Extent Report");
    	
    	extent=new ExtentReports();
    	extent.attachReporter(sr);
    	extent.setSystemInfo("Tester", "Radhika");
    }
	
	@Test
	public void InitialDemo()
	{
		extent.createTest("Initial Test");
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\CourseWorkspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String url="www.google.com";
		driver.get(url);
		//System.out.println(driver.getTitle());	
		
		extent.flush();
		driver.quit();
	}

}
