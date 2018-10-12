package LoginPage;

import base.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonApi {
    //*******************  Define Elements  ***********************
    @FindBy(xpath = "//*[@id=\"_P002_Menu_WAR_P002_Menuportlet__VIEW\"]/div/div/header/div[2]/div/div/nav/div[1]/span")
    public static WebElement LoginPage;
    @FindBy(xpath = "//input[@id='_P002_Menu_WAR_P002_Menuportlet_entrada.alias']")
    public static WebElement UserInput;
    @FindBy(xpath = "//input[@id='_P002_Menu_WAR_P002_Menuportlet_entrada.pwd']")
    public static WebElement PassWordInput;
    @FindBy(xpath = "//button[@id='_P002_Menu_WAR_P002_Menuportlet_loginButtonTM']")
    public static WebElement LoginButton;
    @FindBy(xpath = "//*[@id=\"_P002_Menu_WAR_P002_Menuportlet_formLogin\"]/fieldset/div/span/div[1]")
    public static WebElement errorMsg;


    //**************** Define Method For Manual login *********************
    public void checkLoginFuction(){
        UserInput.sendKeys("nasirvi@yahoo.com");
        PassWordInput.sendKeys("1234");
        LoginButton.click();

    }
    //**************** Define Method For Data  *********************

public void logInUsingDataProvider(String email, String password) throws InterruptedException{
        UserInput.sendKeys(email);
        PassWordInput.sendKeys(password);
        LoginButton.click();
}
}
