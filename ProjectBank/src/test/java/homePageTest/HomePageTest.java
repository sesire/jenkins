package homePageTest;

import homeFolder.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends HomePage {
    HomePage homePage;
    @BeforeMethod
    public void initializing() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    @Test(priority = 1,enabled = false)
    public void header_Taeget_Test(){ homePage.header_Taeget();}
    @Test(priority = 2,enabled = false)
    public void Personal_Textoption_Test(){ homePage.personal_Textoption(); }
    @Test(priority = 3,enabled = false)
    public void Business_Textoption_Test(){ homePage.business_Textoption(); }
    @Test(priority = 4,enabled = false)
    public void Corporate_Textoption_Test(){homePage.corporate_Textoption();}
    @Test(priority = 5,enabled = false)
    public void About_Textoption_Test(){homePage.about_Textoption();}
    @Test(priority = 6,enabled = false)
    public void ATM_BranchLocation_Test(){homePage.aTM_BranchLocation();}
    @Test(priority = 7,enabled = true)
    public void Login_Test(){homePage.login();}
}
