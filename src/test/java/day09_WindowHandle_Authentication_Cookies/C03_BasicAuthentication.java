package day09_WindowHandle_Authentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

public class C03_BasicAuthentication extends TestBase1 {

    /*

    Herhangi bir internet kullanıcısının, uygulamanın ya da programın, söz konusu sisteme dahil olup olamayacağını
    belirleyen doğrulama sistemini ifade eder

    Uygulama ana sayfalarindaki kullanici adi ve password istemek de bir authentication’dir

    Bu authentication’i yapabilmek icin uygulamanin kullanicilara  authentication’i nasil yapacagina
    dair bilgilendirme yapmis olmasi gerekir.

    BasicAuthentication açılan pop-uptır ama bir Alert degildir. o Yuzden Alert gibi işlenmez. Bize url ve adres formatı verilir.
    Ona göre işlem yapılır

     */

    @Test
    public void basicAuthentication() {
        //--------------------------------------------------------------------
        // 1. Bir class olusturun : BasicAuthentication
        //2. https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3. asagidaki yontem ve test datalarini kullanarak authentication’i
        //yapin
        //URL : https://username:password@URL
        //Username : admin
        //password : admin

        //Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın

        //driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Authentication URLimiz --> https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        waitFor(3);
        String actualText = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(actualText.contains("Congratulations!"));



    }

}
