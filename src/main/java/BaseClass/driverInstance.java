package BaseClass;

import Utility.extentReportUtility;
import Utility.utility_fetch_property;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class driverInstance
{
    public WebDriver driver;
    @BeforeMethod
    public void initiateDriverInstance() throws IOException {
        String browsername = utility_fetch_property.fetch_property_value("browser");
        switch (browsername) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        //driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        extentReportUtility.blankFile_Creation(this.getClass().getSimpleName());
        driver.get(utility_fetch_property.fetch_property_value("url"));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void classInstance(ITestResult result) throws IOException {
        extentReportUtility.reportgeneration(result, driver);
        driver.quit();
    }
}
