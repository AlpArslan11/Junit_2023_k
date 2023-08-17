package Alparslan.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;


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
            System.out.println(sayac +" inci DROPDOWN elementi -->   " + e.getText());

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
            String urunTitleIphone = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
            String urunPriceIphone = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        // ürünü sepete ekleyelim
            driver.findElement(By.id("add-to-cart-button")).click();

        //sepette warmı kontrol edelim
        driver.findElement(By.id("nav-cart-count-container")).click();
        List<WebElement> activeProductsInCart = driver.findElements(By.xpath("//*[@data-itemtype='active']"));

        String []urunTitleArr = urunTitleIphone.split(" ");
        String urunTitleIlk3tanesiStrIphone ="";


        for (int i = 0; i < 3; i++) {
            urunTitleIlk3tanesiStrIphone += urunTitleArr[i] + " ";
        }
        System.out.println("iphone title 3 kelime STRİNG olarak --->  " + urunTitleIlk3tanesiStrIphone);
        for (WebElement e: activeProductsInCart
             ) {

            if (e.getText().contains(urunTitleIlk3tanesiStrIphone)){
                Assert.assertTrue("sepetteki urun eklenen urun degil"
                        ,e.getText().contains(urunTitleIlk3tanesiStrIphone));
                break;
            }
        }


        //Test03
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2);
        driver.get("https://www.amazon.com");

        //2. dropdown’dan bebek bölümüne secin
        ddm = driver.findElement(By.xpath("//*[@title='Search in']"));
        select  = new Select(ddm);
        select.selectByVisibleText("Baby");
        Thread.sleep(2);

        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        try {   Thread.sleep(2000); } catch (InterruptedException e) { throw new RuntimeException(e); }

        //4. sonuç yazsının puset içerdiğini test edin
        String strBonucYazisiBebek = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String expectedvalue = "puset";
        Assert.assertTrue("sonuç yazsının puset içermiyor",strBonucYazisiBebek.contains(expectedvalue));

        //5-üçüncü ürüne relative locater kullanarak tıklayin

        WebElement ikinciBebekPusetUrun = driver.findElement(By.xpath("//*[@data-component-id='21']"));

        WebElement ucuncuBebekPusetUrun = driver.findElement(
                By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]"));
        ucuncuBebekPusetUrun.click();

        Thread.sleep(2);


        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urunTitlePuset = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunPricePuset = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();

        //ürünü sepete ekleyin
        driver.findElement(By.id("add-to-cart-button")).click();

        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        //sepette warmı kontrol edelim
        Thread.sleep(2000);
        driver.findElement(By.id("nav-cart-count-container")).click();
        activeProductsInCart = driver.findElements(By.xpath("//*[@data-itemtype='active']"));

        urunTitleArr = urunTitlePuset.split(" ");
        String urunTitleIlk3tanesiStrPuset ="";





        for (int i = 0; i < 3; i++) {
            urunTitleIlk3tanesiStrPuset += urunTitleArr[i] + " ";
        }
        System.out.println("Puset title 3 kelime STRİNG olarak --->  " + urunTitleIlk3tanesiStrPuset);
        for (WebElement e: activeProductsInCart
        ) {

            if (e.getText().contains(urunTitleIlk3tanesiStrPuset)){
                Assert.assertTrue("sepetteki puset eklenen urun degil"
                        ,e.getText().contains(urunTitleIlk3tanesiStrPuset));
                break;
            }
        }


        for (WebElement e: activeProductsInCart
        ) {

            if (e.getText().contains(urunTitleIlk3tanesiStrIphone)){
                Assert.assertTrue("sepetteki iphone eklenen urun degil"
                        ,e.getText().contains(urunTitleIlk3tanesiStrIphone));
                break;
            }
        }


    }






}
