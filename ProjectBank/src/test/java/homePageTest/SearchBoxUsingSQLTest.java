package homePageTest;

import homeFolder.HomePage;
import homeFolder.SearchBoxCheckPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBoxUsingSQLTest extends SearchBoxCheckPage {
    SearchBoxCheckPage searchBoxCheckPage;
    @BeforeMethod
    public void initElement(){searchBoxCheckPage=PageFactory.initElements(driver,SearchBoxCheckPage.class);
    }
    //************** Test-cases for searching items with DB data  *****************************************************
    @Test(priority = 1, enabled = true)
    public void testSearchByDBData() throws Exception {
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        searchBoxCheckPage.searchItemsFromDB();
    }
}
