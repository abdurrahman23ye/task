package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaMainPage {

    public HepsiBuradaMainPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@title='Giriş Yap']")
    public WebElement loginOptions;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement loginButton;


}
