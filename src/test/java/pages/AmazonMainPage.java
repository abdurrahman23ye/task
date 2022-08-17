package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonMainPage {

    public AmazonMainPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement signinOptions;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement signin;

    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    public WebElement cartButton;








}
