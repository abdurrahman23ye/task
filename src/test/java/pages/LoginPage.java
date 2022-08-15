package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userNameLabel;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement loginButton;

}
