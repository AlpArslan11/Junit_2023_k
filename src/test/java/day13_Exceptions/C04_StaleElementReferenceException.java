package day13_Exceptions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class C04_StaleElementReferenceException extends TestBase1 {

    /*
    Stale --> eskimiş, yıpranmış, modası gecmiş
    Sayfayı yenilediğinizde (refresh)
    When we refresh page, the elements are no longer attached to dom
     */



    @Test
    public void staleElementReferenceExceptionTest1(){

        driver.get("https://www.techproeducation.com");
        waitFor(5);

//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS"));
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("LMS"));//URl in lms kelimesini icerdigini test et
        waitFor(5);

        /*
        lmsLoginLink linkini sayfa yeniledikten (back()) sonra kullandığım için
        StaleElementReferenceException aldim
         */




//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git
    }

    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();
        // SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTİ, SAYFA YENİLENDİKTEN SONRA KULLANMAK ISTEDİM


        // COZUM OLARAK ELEMENTİ TEKRAR LOCATE EDERIZ
        driver.findElement(By.linkText("LMS"));


    }
}
