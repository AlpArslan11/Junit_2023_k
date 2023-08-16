package Alparslan.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Homework_03 extends TestBase1 {



    @Test
    public void genelTestOdev() throws InterruptedException {
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
        try {   Thread.sleep(2000); } catch (InterruptedException e) { throw new RuntimeException(e); }

        // bulunan sonuç sayısını yazdırın
        String sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        int sonucSayisi = parseInt( sonucYazisi.split("over")[1].replaceAll("\\D","") );
        System.out.println("Bulunan sonuc Yazısı --->  " + sonucSayisi);


        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedText = "iphone";
        Assert.assertTrue("Sonuc yazisi iphone icermiyor",sonucYazisi.contains(expectedText));



        //4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@data-index='2']"));
        WebElement ikinciUrun =
                driver.findElement(with(By.tagName("div")).toRightOf(ilkUrun));

        Thread.sleep(2);
        ikinciUrun.click();


        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
            String urunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
            String urunPrice = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        // ürünü sepete ekleyelim
            driver.findElement(By.id("add-to-cart-button")).click();

        //sepette warmı kontrol edelim
        driver.findElement(By.id("nav-cart-count-container")).click();
        List<WebElement> activeProductsInCart = driver.findElements(By.xpath("//*[@data-itemtype='active']"));

        String []urunTitleArr = urunTitle.split(" ");
        String urunTitleIlk3tanesiStr ="";


        for (int i = 0; i < 3; i++) {
            urunTitleIlk3tanesiStr += urunTitleArr[i].toString()+" ";
        }

        for (WebElement e: activeProductsInCart
             ) {

            if (e.getText().contains(urunTitleIlk3tanesiStr)){
                Assert.assertTrue("sepetteki urun eklenen urun degil"
                        ,e.getText().contains(urunTitleIlk3tanesiStr));
                break;
            }
        }


        //Test03
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2);
        driver.get("https://www.amazon.com");

        //2. dropdown’dan bebek bölümüne secin
        select.selectByVisibleText("Baby");
        Thread.sleep(2);

        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın

        //4. sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayı
    }






}
