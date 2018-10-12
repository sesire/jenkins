package LoginPage;

import base.CommonApi;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static googleAPIs.GoogleSheetReader.getSheetsService;

public class LoginUsingGoogleSheetPage extends CommonApi {

    //*******************  Define Elements  ***********************
    @FindBy(xpath = "//*[@id=\"_P002_Menu_WAR_P002_Menuportlet__VIEW\"]/div/div/header/div[2]/div/div/nav/div[1]/span")
    public static WebElement LoginPage;
    @FindBy(xpath = "//input[@id='_P002_Menu_WAR_P002_Menuportlet_entrada.alias']")
    public static WebElement UserInput;
    @FindBy(xpath = "//input[@id='_P002_Menu_WAR_P002_Menuportlet_entrada.pwd']")
    public static WebElement PassWordInput;
    @FindBy(xpath = "//button[@id='_P002_Menu_WAR_P002_Menuportlet_loginButtonTM']")
    public static WebElement LoginButton;
    @FindBy(xpath = "(//div[@class='error'])[1]")
    public static WebElement errorMsg;

    //****************** Google Sheet Reading method *****************************


    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }

    public List<String> signInByInvalidCredentials(String spreadsheetId, String range) throws IOException, InterruptedException {
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<List<Object>> col2Value = getSpreadSheetRecords(spreadsheetId, range);
        List<String> actual = new ArrayList<>();
        for (List row : col2Value) {
            sleepFor(1);
            inputValueInTextBoxByWebElement(UserInput, row.get(1).toString());
            inputValueInTextBoxByWebElement(PassWordInput, row.get(2).toString());
            LoginButton.click();
            sleepFor(2);
            actual.add(getTextByWebElement(errorMsg));
            clearInputBox(UserInput);
            clearInputBox(PassWordInput);
            sleepFor(1);
        }
        return actual;
    }
}
