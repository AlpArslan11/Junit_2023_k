package Alparslan.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Homework_03 extends TestBase1 {



    @Test
    public void genelTestOdev(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@title='Search in']"));
        Select select  = new Select(ddm);

        List<WebElement> ddmList = select.getOptions();

        int sayac =0;
        for (WebElement e : ddmList) {
            sayac++;
            System.out.println(sayac +" inci element" + e.getText());

        }



        //3. dropdown menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals("dropdown menude 28 eleman yok",28,ddmList.size());

        //Test02
        //1. dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
        try {   Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }

        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        try {   Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }

        // bulunan sonuç sayısını yazdırın
        String sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        int sonucSayisi = parseInt( sonucYazisi.split("over")[1].replaceAll("\\D","") );
        System.out.println("Bulunan sonuc Yazısı --->  " + sonucSayisi);


        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedText = "iphone";
        Assert.assertTrue("Sonuc yazisi iphone icermiyor",sonucYazisi.contains(expectedText));



        //4. ikinci ürüne relative locater kullanarak tıklayin

        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        //Test03
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        //2. dropdown’dan bebek bölümüne secin
        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4. sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayı
    }






}
