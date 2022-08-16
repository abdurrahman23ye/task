package tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoggedMainPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchedSamsungListPage;
import utilities.CookieLogin;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.FileInputStream;
import java.io.IOException;

public class HepsiburadaTask extends TestBaseReport {


    //raporlama icin TestBaseReport'u parent class olarak sectim.
    //Raporlama içib aventstack kutuphanesinden yararlandım.



    @Test
    public void hepsiBuradaTask() throws IOException, InterruptedException {

        MainPage mainPage=new MainPage();
        LoginPage loginPage=new LoginPage();
        LoggedMainPage loggedMainPage=new LoggedMainPage();
        SearchedSamsungListPage searchedSamsungListPage=new SearchedSamsungListPage();
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        SoftAssert sf=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("hepsiBurada", "Task");

         //Hepsiburada sitesine otomasyonla giriste kisitlama mevcut oldugu icin username+sifre ile
        // giris sağlayamadım, girisi cookieler ile yaptım.

        extentTest.info("Kullanici hepsiburada web sayfasina gider");

        CookieLogin.cookieLogin();

        Driver.getDriver().navigate().refresh();



        extentTest.info("Kullanici Arama kutusuna samsung yazıp arama tusuna basar");



        String path="src/test/resources/optiim.xlsx";

        FileInputStream fis= new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(fis);

        String searchingWord= workbook.getSheet("Sayfa2").getRow(2).getCell(1).toString();

        loggedMainPage.searchBox.sendKeys(searchingWord+ Keys.ENTER);



        extentTest.info("Kullanici sol taraftaki menuden önce telefon sonra cep telefonu kategorilerini tiklar");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

       searchedSamsungListPage.telefonCategory.click();

        Thread.sleep(3000);






















    }
}
