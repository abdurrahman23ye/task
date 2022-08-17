package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonProductPage {

    public AmazonProductPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
    public WebElement addToListButton;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement selectedProductTitle;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/hz/wishlist/ls/2TFMJFBLD3L36?ref_=wl_dp_view_your_list']")
    public WebElement viewYourListButton;







}
