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

    @FindBy(xpath = "  //div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultLabel;

    @FindBy(xpath = "//a[@aria-label='Go to page 2']")
    public WebElement resultsSecondPage;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")//urun Turkiye'de satilmiyorsa bulunamazsa buradan degisiyoruz.
    public WebElement fifthProduct;










}
