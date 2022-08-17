package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonListPage {

    public AmazonListPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@class='a-size-base']")
    public WebElement listedProductTitle;

    @FindBy(xpath = "//a[@class='a-button-text a-text-center']")
    public WebElement buyingOptions;


    @FindBy(xpath = "//input[@name='submit.addToCart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='a-alert-content']")
    public WebElement addedToCartAlert;















}
