package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void StartDriver(@Optional("chrome")String browserName)
    {

        if (browserName.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-extensions");

            driver = new EdgeDriver(options);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void StopDriver()
    {
        driver.quit();
    }

    //Take Screenshot when test case fail and add it to Screenshots folder
    @AfterMethod
    public void ScreenShotOnFailure(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshots ......");
            Helper.CaptureScreenshot(driver, result.getName());
        }
    }
}
