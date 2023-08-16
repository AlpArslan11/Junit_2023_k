package Alparslan.day07_TestBase_AhmetB;

import org.junit.Assert;
import org.junit.Test;
import utilities1.TestBase1;

public class C01_TestBaseDemo extends TestBase1 {

    /*
    Utilities ne demek?
    - Utilities tekrar tekrar kullanacağimiz methodlari yada classlari koydugumuz paketin adididr.
        -TestBase
        -Driver
        -ExcelUtil
        -Configuration
    - Utilities paketinde TEst caeler yazılmaz
    - Sadece tekrar kullanılabilecek destek sonoflari(Support Classlari) olusturulur
    -Bu support classlar test caselerin yazılmasını hizlandirir
     */


        @Test
        public void test1(){
            // techrpoeducation ana sayfasına git ve
            driver.get("https://techproeducation.com");
            //title'ın Education kelimesi icerdiğini test et
            System.out.println("site title = " +driver.getTitle());
            Assert.assertTrue("title education icermiyor",driver.getTitle().contains("Education"));

        }

}
