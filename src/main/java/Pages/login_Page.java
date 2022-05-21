package Pages;

import Utility.extentReportUtility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_Page
{
    WebDriver driver;

    public login_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterUsername(String Username)
    {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Username);
        extentReportUtility.logger.log(Status.INFO,"Succesfully entered Username: "+Username);
    }
    public void enterPassword(String Password)
    {
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
        extentReportUtility.logger.log(Status.INFO,"Succesfully entered Password: "+Password);
    }
    public void clickSignIn()
    {
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        extentReportUtility.logger.log(Status.INFO, "Succesfully clicked on Sign In");
    }
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        extentReportUtility.logger.log(Status.INFO, "Succesfully Logged out");

    }


}