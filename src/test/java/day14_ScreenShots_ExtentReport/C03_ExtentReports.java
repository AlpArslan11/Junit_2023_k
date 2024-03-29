package day14_ScreenShots_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

import java.text.SimpleDateFormat;
import java.util.Date;
public class C03_ExtentReports extends TestBase1 {
    //    HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;  // sablon olusturur
    protected static ExtentHtmlReporter extentHtmlReporter;  // sablonu projeye ekler
    protected static ExtentTest extentTest;  // raporlama islemini yapar. loglari rapora yazdırır.
    @Test
    public void extentReportsTest(){
//      REPORT  PATH --> altyapıyı hazırladık
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


//       *************************************RAPORU CUSTOMIZE EDEBILIRIZ*********************
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Ahmet");


//        *********************************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRIZ****
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");


//        ********************************RAPOR AYARLARI BITTI****************************

//        Raporu projeme ekliyorum - Test sayfaarına yazılan kısım
        extentReports.attachReporter(extentHtmlReporter);
//        Extent Test objesi ni olustur
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

//        TUM AYARLAR BITTI. EXTENT TEST OBJESI ILE LOGLAMA(RAPORA YAZDIRMA) ISLEMINI YAPABILIRIM
        extentTest.pass("Kullanici ana sayfaya gider");
        driver.get("https://www.techproeducation.com");
//        LMS SAYFASINA GIDELIM
        extentTest.pass("Kullanici LMS sayfasina gider");
        driver.findElement(By.linkText("LMS")).click();
//        TEST BITTI
        extentTest.pass("TEST BASARIYLA GERCEKLESDI");
//        RAPORU GOSTER. RAPORUN OLUSMASI ICIN BU ADIM ZORUNLUDUR
        extentReports.flush();
    }

//    1. ExtentReports kütüphanesini projemize ekleriz
//    2. ExtentReports ve ExtentHtmlReporter sınıfları ile raporun şablonu, dosya yolunu oluştururuz
//    3. ExtentTest sınıfı ile de raporu oluştururur ve yükleriz





}