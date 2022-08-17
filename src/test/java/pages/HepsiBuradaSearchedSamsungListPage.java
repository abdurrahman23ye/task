package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaSearchedSamsungListPage {

    public HepsiBuradaSearchedSamsungListPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='treeCategoryContent-treeTitleContainer'])[1]")
    public WebElement telefonCategory;


    @FindBy(xpath = "//div[@class='searchResultSummaryBar-mainText']")
    public WebElement searchResult;

    @FindBy(xpath = "(//h3[@data-test-id='product-card-name'])[5]")
    public WebElement fifthProduct;







}
