package loginPageTest;

import LoginPage.LoginUsingGoogleSheetPage;
import homeFolder.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LogInPageTestWithGoogleSheet extends LoginUsingGoogleSheetPage {
    HomePage homePage;
    LoginUsingGoogleSheetPage loginUsingGoogleSheetPage;
    //************** Initializing elements of pages******************************************
    @BeforeMethod
    public void intializeElements(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        //pharmecyPage = PageFactory.initElements(driver,PharmecyPage.class);
        loginUsingGoogleSheetPage = PageFactory.initElements(driver,LoginUsingGoogleSheetPage.class);
    }

    //********** checking invalid login error messages using google sheet*******************************
    @Test(priority = 1,enabled = true)
    public void testSignInByInvalidCredentials() throws InterruptedException, IOException {
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        homePage.login();
        sleepFor(2);
        int i = 0;
        String spreadsheetId = "1r7vJp3FX5oRzEK-4W5q3HRl9Jq5LYJmOVUcRDqguzag";
        String range = "Sheet1!A2:D";
        List<String> actualMessage = loginUsingGoogleSheetPage.signInByInvalidCredentials(spreadsheetId,range);
        List<List<Object>> expectedMessage = loginUsingGoogleSheetPage.getSpreadSheetRecords(spreadsheetId,range);
        for (List row : expectedMessage) {
            System.out.println("exp: "+row.get(3));
            System.out.println("act: "+ actualMessage.get(i));
            Assert.assertTrue(actualMessage.get(i).contains(row.get(3).toString()));
            i++;

        }
    }
}
