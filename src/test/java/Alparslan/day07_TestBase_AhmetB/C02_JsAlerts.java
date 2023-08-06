package Alparslan.day07_TestBase_AhmetB;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class C02_JsAlerts extends TestBase1 {
    /*
    bir testi çalıştırırken açılan pop-uplar alerttir.
    Eger bu acilan pop-upları sağ click ile inspect yapabiliyorsak bunlar HTML alerttir.
    Diğer tüm webelementler gibi locate edebiliriz ve kullanabiliriz.

    ANCAK
    sağ click yapıp inspect yapamıyorsak bunlar javascript alert olabilir.
    JavaScript alertler locate edilemez sadece driver'imizi o alerte switch yapıp islem yapabiliriz.

    Developerlar bunu onclick=JsAlert() attribute ile gömer siteye.
    Simple Alerts tek seçenek
    Confirmation alert 2 seçenek ok yada cancel gibi
    Prompt alert kullanıcı not yazabilir. OK ve cancel gibi 2 seçene vardir.

    methodlari
        - accept()
        - dismis()
        - sendKeys("Text")
        - getText()

     */


        /*
        Alertleri nasıl automate edersin? How to handle alerts in selenium
        -Alertler javascript ile oluşturulur. inspect edilemezler. Öncelikle alerte switch etmemiz gerekir.
         */



    @Test
    public void acceptAlert() throws InterruptedException {
        //Bir class olusturun: Alerts
        //● https://testcenter.techproeducation.com/index.php?page=javascript-alerts    adresine gidin.
        //● Bir metod olusturun: acceptAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");

        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
        WebElement jsAlertButon = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]"));
        jsAlertButon.click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // ok seceneğine tıklayalim

        //result mesajının “You successfully clicked an alert” oldugunu test edin.
        WebElement actaulResult = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals("JsAlert metni uyuşmuyor",actaulResult.getText(),expectedText );
    }
    
    

    //● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
    //mesajının “You clicked: Cancel” oldugunu test edin.
    //● Bir metod olusturun: sendKeysAlert
    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK
    //butonuna tıklayın ve result mesajında isminizin görüntülendiğini
    //doğrulayın





}
