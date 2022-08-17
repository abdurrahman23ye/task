package tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AmazonTest extends TestBaseReport {


    @Test
    public void AmazonTest() throws IOException, InterruptedException {

        AmazonMainPage amazonMainPage=new AmazonMainPage();
        AmazonSigninPage amazonSigninPage=new AmazonSigninPage();
        AmazonLoggedMainPage amazonLoggedMainPage=new AmazonLoggedMainPage();
        AmazonSearchPage amazonSearchPage=new AmazonSearchPage();
        AmazonProductPage amazonProductPage=new AmazonProductPage();
        AmazonListPage amazonListPage=new AmazonListPage();
        AmazonCartPage amazonCartPage=new AmazonCartPage();


        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        SoftAssert sf=new SoftAssert();
        Actions action=new Actions(Driver.getDriver());
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        extentTest = extentReports.createTest("Amazon", "Interview Task");



        extentTest.info("Kullanici Amazon web sayfasina gider ve sayfanin acildigini onaylar");

        Driver.getDriver().get("https://www.amazon.com/");

        sf.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.amazon.com/"));




        extentTest.info("Kullanici login sayfasini acip kayitli bir kullanici ile giris yapar");

        action.moveToElement(amazonMainPage.signinOptions).perform();

        amazonMainPage.signin.click();

        String path="src/test/resources/optiim.xlsx";

        FileInputStream fis= new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(fis);

        String userName= workbook.getSheet("Sayfa2").getRow(0).getCell(1).toString();

        amazonSigninPage.username.sendKeys(userName);

        amazonSigninPage.continueButton.click();

        String password= workbook.getSheet("Sayfa2").getRow(1).getCell(1).toString();

        amazonSigninPage.password.sendKeys(password);

        amazonSigninPage.signin.click();




        extentTest.info("Kullanici arama kutusuna Samsung yazip arama yapar");

        String searchingWord= workbook.getSheet("Sayfa2").getRow(2).getCell(1).toString();

        amazonLoggedMainPage.searchBox.sendKeys(searchingWord+ Keys.ENTER);




        extentTest.info("Kullanici arama sonuclarini cep telefonlari ile filtreler.");

        amazonSearchPage.cellPhonesCategory.click();



        extentTest.info("Kullanici arama sonuclarinin samsung icerdigini dogrular");

        sf.assertTrue(amazonSearchPage.resultLabel.getText().contains(searchingWord));






        extentTest.info("Kullanici sonuclardan ikinci sayfaya tiklar ve bunu dogrular");


        jse.executeScript("arguments[0].scrollIntoView()", amazonSearchPage.resultsSecondPage);
        jse.executeScript("arguments[0].click()", amazonSearchPage.resultsSecondPage);

        // Sayfada asagi inilecek birim mesafe stabil olmadigi icin javaexecuter kullandim.

        sf.assertTrue(amazonSearchPage.resultLabel.getText().contains("25-48"));

        //Ikinci sayfada oldugumu dogrulamak icin sonuc labelindeki urun siralamasini kullandim.





        extentTest.info("Kullanici besinci siradaki urune tiklar");

        amazonSearchPage.fifthProduct.click();

        String selectedProductName=amazonProductPage.selectedProductTitle.getText(); //ilerdeki dogrulama icin


        extentTest.info("Kullanici urunu listeye ekler");

        //Hepsiburada'daki begene muadil Amazon'da listeye ekleme mevcut.

        amazonProductPage.addToListButton.click();



        extentTest.info("Kullanici urunu listesine gider ve ekledigi urunun listede oldugunu dogrular");

        amazonProductPage.viewYourListButton.click();

        sf.assertTrue(amazonListPage.listedProductTitle.getText().equals(selectedProductName));



        extentTest.info("Kullanici satin alma seceneklerini goruntuler ve urunu sepete ekler");

        amazonListPage.buyingOptions.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='submit.addToCart']")));

        amazonListPage.addToCartButton.click();


       


        extentTest.info("Kullanici urunun sepete eklendigini dogrular");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-alert-content']")));


        sf.assertTrue(amazonListPage.addedToCartAlert.isDisplayed());






        extentTest.info("Kullanici sepete gider");

        Driver.getDriver().navigate().back();

        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView();", amazonMainPage.cartButton);
        jse.executeScript("arguments[0].click();", amazonMainPage.cartButton);



        extentTest.info("Kullanici ekledigi urunu sepetten kaldirir");

        amazonCartPage.deleteProduct.click();

        extentTest.pass("Kullanici ekledigi urunu sepetten kaldiririldigini dogrular");

       sf.assertTrue( amazonCartPage.deletedAlert.isDisplayed());


        sf.assertAll();

    }
}
