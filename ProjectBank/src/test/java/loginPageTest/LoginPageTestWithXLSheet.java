package loginPageTest;

import LoginPage.LoginPage;
import datProviderUtilityWIthXlsReader.XlsDataReaderUtil;
import homeFolder.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginPageTestWithXLSheet extends LoginPage{
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initializing() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage=PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 1,enabled = true)
    public void manualInputTest(){
        homePage.login();
        loginPage.checkLoginFuction();}

    //************* Define Data Provider For XL Sheet read  ************
    @DataProvider
    public Iterator<Object[]> supplyData(){
        ArrayList<Object[]> testData = XlsDataReaderUtil.getDataFromExcel();
        return testData.iterator();
    }
    @Test(priority = 2,enabled = false,dataProvider = "supplyData")
    public void logInTest(String email, String password) throws InterruptedException{
        homePage.login();
        loginPage.logInUsingDataProvider(email,password);
    }
}
