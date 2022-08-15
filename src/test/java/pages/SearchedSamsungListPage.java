package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchedSamsungListPage {

    public SearchedSamsungListPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='treeCategoryContent-treeTitleContainer'])[1]")
    public WebElement telefonCategory;

    @FindBy(xpath = "//a[@href='https://www.hepsiburada.com/cep-telefonlari-c-371965']")
    public WebElement cepTelefonuCategory;



}
