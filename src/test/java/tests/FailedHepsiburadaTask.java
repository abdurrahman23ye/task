package tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.FileInputStream;
import java.io.IOException;

public class FailedHepsiburadaTask extends TestBaseReport {

    //Bana gönderilen taski manuel olarak kontrol ettiğimde herhangi bir sorun olmadığı halde
    // otomasyonla gerçekleştirmek istediğimde sürekli olarak aynı adımda başarısız oldum. Cookieleri ve
    // farklı browserları kontrol edince de sonuç değişmedi. Problemin benim bilgisayarımdan kaynaklanmadigina
    // emin olmak icin bir arkadasimdan otomasyonla siteye ulasmasini istedim ama o da ayni
    // durumla karsilasti. Muhtemelen siteye otomasyon ile üye girişi

    //kısıtlaması mevcut. Sorunu videoya çektim ve giris yapamadığım testi buraya bıraktım.




    //raporlama icin TestBaseReport'u parent class olarak sectim.
    //Raporlama içib aventstack kutuphanesinden yararlandım.



    @Test
    public void hepsiBuradaTask() throws IOException, InterruptedException {

        MainPage mainPage=new MainPage();
        LoginPage loginPage=new LoginPage();

        extentTest = extentReports.createTest("hepsiBurada", "Task");



        extentTest.info("Kullanici hepsiburada web sayfasina gider");

        Driver.getDriver().get("https://www.hepsiburada.com/");




        extentTest.info("Kullanici login secenekleri butonuna basar");

        mainPage.loginOptions.click();



        extentTest.info("Kullanici acilan menuden login butonuna basar");

        mainPage.loginButton.click();



        extentTest.info("Kullanici userName sekmesine kayitli bir email adresi girer ve login butonuna basar");
        //Kayitli email srx->resources->hepsiBuradaTask dosyasindan alindi.

        String path="src/test/resources/optiim.xlsx";

        FileInputStream fis= new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(fis);

        String userName= workbook.getSheet("Sayfa2").getRow(0).getCell(1).toString();

        loginPage.userNameLabel.sendKeys(userName);


        loginPage.loginButton.click();








    }
}
