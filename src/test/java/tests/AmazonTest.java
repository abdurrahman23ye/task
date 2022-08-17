package tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonLoggedMainPage;
import pages.AmazonMainPage;
import pages.AmazonSearchPage;
import pages.AmazonSigninPage;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AmazonTest extends TestBaseReport {


    @Test
    public void AmazonTest() throws IOException {

        AmazonMainPage amazonMainPage=new AmazonMainPage();
        AmazonSigninPage amazonSigninPage=new AmazonSigninPage();
        AmazonLoggedMainPage amazonLoggedMainPage=new AmazonLoggedMainPage();
        AmazonSearchPage amazonSearchPage=new AmazonSearchPage();

        SoftAssert sf=new SoftAssert();
        Actions action=new Actions(Driver.getDriver());

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

        sf.assertAll();














    }
}