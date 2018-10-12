package homeFolder;

import base.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonApi {
    //**********************  Elements Define  ********************************
    @FindBy(xpath = "//*[@id=\"_P001_Header_WAR_P001_Headerportlet__VIEW\"]/div/div/div[1]/p/a/img")
    public static WebElement Header_Taeget;
    @FindBy(css = "#navsup > nav > ul > li:nth-child(1) > a")
    public static WebElement Personal_Textoption;
    @FindBy(css="#navsup > nav > ul > li:nth-child(2) > a")
    public static WebElement Business_Textoption;
    @FindBy(xpath = "//*[@id=\"navsup\"]/nav/ul/li[3]/a")
    public static WebElement Corporate_Textoption;
    @FindBy(xpath = "//*[@id=\"navsup\"]/nav/ul/li[4]/a")
    public static WebElement About_Textoption;
    @FindBy(xpath = "//*[@id=\"navsup\"]/nav/div/div/div[1]/a")
    public static WebElement ATM_BranchLocation;
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    public static WebElement Login;

    //*************  Define functions of above elements  ****************

    public void header_Taeget(){Header_Taeget.click();}
    public void personal_Textoption(){Personal_Textoption.click();}
    public void business_Textoption(){Business_Textoption.click();}
    public void corporate_Textoption(){Corporate_Textoption.click();}
    public void about_Textoption(){About_Textoption.click();}
    public void aTM_BranchLocation(){ATM_BranchLocation.click();}
    public void login(){Login.click();}

}
