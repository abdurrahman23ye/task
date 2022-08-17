package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonCartPage {

    public AmazonCartPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@data-action='delete']")
    public WebElement deleteProduct;

    @FindBy(xpath = "//span[@class='a-size-base']")
    public WebElement deletedAlert;









}
