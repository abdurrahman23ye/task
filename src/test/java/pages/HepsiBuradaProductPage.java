package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaProductPage {

    public HepsiBuradaProductPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='customerAccount-Like-2wPzH']")
    public WebElement likeButton;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    public WebElement productAddedToList;







}
