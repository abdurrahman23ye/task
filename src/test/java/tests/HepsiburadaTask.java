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
import utilities.CookieLogin;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class HepsiburadaTask extends TestBaseReport {


    //raporlama icin TestBaseReport'u parent class olarak sectim.
    //Raporlama içib aventstack kutuphanesinden yararlandım.



    @Test
    public void hepsiBuradaTask() throws IOException, InterruptedException {


        HepsiBuradaLoggedMainPage hepsiBuradaLoggedMainPage =new HepsiBuradaLoggedMainPage();
        HepsiBuradaSearchedSamsungListPage hepsiBuradaSearchedSamsungListPage =new HepsiBuradaSearchedSamsungListPage();
        HepsiBuradaProductPage hepsiBuradaProductPage =new HepsiBuradaProductPage();
        HepsiBuradaMyAccountPage hepsiBuradaMyAccountPage =new HepsiBuradaMyAccountPage();

        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        SoftAssert sf=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));



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

        hepsiBuradaLoggedMainPage.searchBox.sendKeys(searchingWord+ Keys.ENTER);



        extentTest.info("Kullanici sol taraftaki menuden önce telefona tiklar");

        /*
        1. Bana verilen takste istenilen aslında
        "Kullanici sol taraftaki menuden önce telefon sonra cep telefonu kategorilerini tiklar"
        fakat  telefonu tıkladıktan sonra menüye cep telefonu opsiyonu gelmiyor. Sayfada cep telefonu
        linki mevcut ama o mevcut aramanin sonuçlarini filtrelemeyip cep telefonu aramasi sayfasina gecis
        sagliyor.

        2. Sayfada telefon kategorisi icin locater istikrarli calismadi o yüzden javasicript executer dan
        yararlandim.
         */

        Thread.sleep(3000);



        jse.executeScript("arguments[0].scrollIntoView()", hepsiBuradaSearchedSamsungListPage.telefonCategory);
        jse.executeScript("arguments[0].click()", hepsiBuradaSearchedSamsungListPage.telefonCategory);

        Thread.sleep(3000);

        extentTest.info("Sayfadaki sobuclarin samsung icerdigi dogrulanacak");

        actions.sendKeys(Keys.PAGE_UP).perform();

        sf.assertTrue(hepsiBuradaSearchedSamsungListPage.searchResult.getText().startsWith("samsung"));



        extentTest.info("Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak");

         //Calisma yaptigim web sayfasinda arama sonuclari sayfa olarak gösterilmemekte. Daha fazla urun goster

        //butonu bulunmakta fakat bu buton sayfada herhangi bir degisiklige yol açmamakta.

        extentTest.info("Kullanici ustten 5. urune tiklar");

        String firstPageHandle=Driver.getDriver().getWindowHandle();

        hepsiBuradaSearchedSamsungListPage.fifthProduct.click();

        String fifthProductText= hepsiBuradaSearchedSamsungListPage.fifthProduct.getText();

        // ileri stepteki dogrulama icin


        Set<String> windowsHandles=Driver.getDriver().getWindowHandles();

        String newPageHandle="";

        for (String each: windowsHandles
             ) {

            if(!each.equals(firstPageHandle)){
                newPageHandle=each;
            }
        }

        Driver.getDriver().switchTo().window(newPageHandle);




        extentTest.info("Kullanici urunu begen butonuna tiklar");

        actions.sendKeys(Keys.PAGE_DOWN);

        hepsiBuradaProductPage.likeButton.click();



        extentTest.info("Kullanici urunu begendikleri listesine ekledigini onaylar");

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='hb-toast-text']"))));
        sf.assertTrue(hepsiBuradaProductPage.productAddedToList.isDisplayed());

        sf.assertAll();

        extentTest.info("Kullanici hesabim sekmesinden begendiklerim linkine tiklar");

        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(2000);

        actions.moveToElement( hepsiBuradaMyAccountPage.myAccountOptions).perform();


        Thread.sleep(1000);



        hepsiBuradaMyAccountPage.favorites.click();












    }
}
