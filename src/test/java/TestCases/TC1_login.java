package TestCases;

import BaseClass.driverInstance;
import Pages.login_Page;
import Utility.excelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC1_login extends driverInstance
{
    @Test(dataProvider = "credentials")
    public void validateLogin(String uname, String pass) throws InterruptedException {
    login_Page login = new login_Page(driver);
    login.enterUsername(uname);
    login.enterPassword(pass);
    login.clickSignIn();

        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard",driver.getCurrentUrl());
        Thread.sleep(3000);

        login.logout();

    }
    @DataProvider(name = "credentials")
    public Object[][] dataprovider () throws IOException {
        //Object[][] test = new Object[][]  {{"Admin","admin123"},{"Aparna","test123"}};
        excelUtility.setExcelFile("./src/test/resources/TestData/Testfile.xlsx", "test_sheet");
        String testcasename = this.getClass().getSimpleName();
        int startingTestCaserow = excelUtility.getrowcontains(testcasename);
        Object[][] tablearray = excelUtility.getExcelTableData(startingTestCaserow);
        return tablearray;
    }
}
