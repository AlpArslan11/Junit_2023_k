package Alparslan.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/*

         Test01 :
         1- amazon gidin
         2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
         3 dropdown menude 40 eleman olduğunu doğrulayın

         Test02
         1 dropdown menuden elektronik bölümü seçin
         2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
         3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
         4 ikinci ürüne relative locater kullanarak tıklayin
         5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

         Test03
         1 yeni bir sekme açarak amazon anasayfaya gidin
         2 dropdown’dan bebek bölümüne secin
         3 bebek puset aratıp bulundan sonuç sayısını yazdırın
         4 sonuç yazsının puset içerdiğini test edin
         5-üçüncü ürüne relative locater kullanarak tıklayin
         6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

         Test 4
         1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayı

         */
public class HM3_Amazon4TestCase extends TestBase1 {

    @Test
    public void test01() throws InterruptedException {
        //  Test01 :
        //  1- amazon gidin
        driver.get("https://www.amazon.com");
        //---> Turkiye olunca hata veriyor.United Kingdom seçelim
        WebElement deliverTo = driver.findElement(By.xpath("//a[@id='nav-global-location-popover-link']"));
        deliverTo.click();
        Thread.sleep(1500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1500);
        actions.sendKeys("U").sendKeys(Keys.ENTER).perform();
        Thread.sleep(1500);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);


        //  2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownAll = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownAll);

        List<WebElement> ddpAllicindekiler = select.getOptions();
        for (int i = 1; i < ddpAllicindekiler.size(); i++) {
            System.out.println(i + ". element -->  " + ddpAllicindekiler.get(i).getText());
        }

        //  3 dropdown menude 40 eleman olduğunu doğrulayın
        int expectedSayi = 40;
        Assert.assertNotEquals("dropdown menude 40 element yok", expectedSayi, ddpAllicindekiler.size());

        //         Test02
        //  1 dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //  2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusuTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuTextBox.sendKeys("iphone", Keys.ENTER);
        Thread.sleep(1000);

        //  3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedYazi = "iphone";
        WebElement aramaSonucYazi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue("iphone", aramaSonucYazi.getText().replaceAll("\\W","").contains(expectedYazi));

        //  4 ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@data-index='1']"));
        WebElement ikinciUrun =
                driver.findElement(with(By.tagName("div")).toRightOf(ilkUrun));

        ikinciUrun.click();

        //  5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String iphoneTitleYazisi = driver.getTitle();

        WebElement iphoneFiyatElement = driver.findElement(By.xpath("(//td[@class='a-span12'])[1]"));
        String iphoneFiyat = iphoneFiyatElement.getText();
        System.out.println("ürünün (iphone) fiyatı " + iphoneFiyat);

        WebElement sepeteEkleElement = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
        sepeteEkleElement.click();


        //  Test03
        //  1 yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");

        //  2 dropdown’dan bebek bölümüne secin
        WebElement dropDownYeniSekmede = driver.findElement(By.id("searchDropdownBox"));
        Select selectYeni = new Select(dropDownYeniSekmede);

        Thread.sleep(2000);
        selectYeni.selectByVisibleText("Baby");
        Thread.sleep(2000);

        //  3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement yeniAramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        yeniAramaKutusu.sendKeys("bebek puset"+Keys.ENTER);   Thread.sleep(1000);
        String bebekPusetAramaSonuc = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText().replaceAll("\\W","");;

        System.out.println("Bebek puset arama sonuc yazisi  :  " +bebekPusetAramaSonuc);

        //  4 sonuç yazsının puset içerdiğini test edin
        expectedYazi = "puset";
        Assert.assertTrue("bebek puset icermiyor yazi" , bebekPusetAramaSonuc.contains(expectedYazi));

        //  5- üçüncü ürüne relative locater kullanarak tıklayin
            WebElement ikinciBebekPusetUrun = driver.findElement(By.xpath("//div[@data-index='2']"));
            WebElement ucuncuBebekPusetUrun = driver.findElement(with(By.className("data-index=")).below(ikinciBebekPusetUrun));
            ucuncuBebekPusetUrun.click();


        //  6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
            String bebekPusetTitle = driver.getTitle();
//            WebElement bebekPusetFiyat = driver.findElement(By)



        // Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayı

    }
}
