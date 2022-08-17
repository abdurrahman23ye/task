package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonSearchPage {

    public AmazonSearchPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "  //span[text()='Cell Phones']")
    public WebElement cellPhonesCategory;

    @FindBy(xpath = "  //div[@class='a-section a-spacing-small a-spacing-top-small']") //unique degil !
    public WebElement resultLabel;







}
