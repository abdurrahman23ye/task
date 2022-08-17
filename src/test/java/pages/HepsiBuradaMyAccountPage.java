package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaMyAccountPage {

    public HepsiBuradaMyAccountPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement myAccountOptions;


    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    public WebElement favorites;




}
