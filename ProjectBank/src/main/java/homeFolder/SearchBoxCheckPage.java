package homeFolder;

import base.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import dataBase.ConnectToSqlDB;
import java.util.ArrayList;
import java.util.List;

public class SearchBoxCheckPage extends CommonApi {
    @FindBy(xpath = "//input[@id='_P001_Header_WAR_P001_Headerportlet_search']")
    public static WebElement searchBox;
    @FindBy(xpath = "//input[@id='_P001_Header_WAR_P001_Headerportlet_searchButton']")
    public static WebElement searchClick;

    //************** Methods for searching items with DB data  ************************************
    List<String> listOfUsername(){
        List<String> list = new ArrayList<>();
        list.add("Debit Card");
        list.add("Credit Card");
        list.add("About");
        return list;
    }
    public void searchItemsFromDB() throws Exception {
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        ConnectToSqlDB.insertDataFromArrayListToMySql(listOfUsername(), "testsearch", "items");
        List<String> itemsToSearch = ConnectToSqlDB.readDataBase("testsearch", "items");
        for (String e: itemsToSearch){
            searchBox.sendKeys(e);
            searchClick.click();
            sleepFor(2);
            driver.navigate().back();
        }
    }

}
