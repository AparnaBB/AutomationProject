package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenshotUtility
{
    public static String getscreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String so = ts.getScreenshotAs(OutputType.BASE64);
        //String path = System.getProperty("user.dir") + "/screenshots/1.jpg";
        //File destination = new File(path);
        //FileUtils.copyFile(source, destination);
        return so;
    }
}
