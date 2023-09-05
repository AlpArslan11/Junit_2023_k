package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;


public class C03_JSExecutor_Type extends TestBase1 {
        /*
        typeTest metotu olustur
        Techpro education ana sayfasina git
         */
        @Test
        public void typeTest(){
//       Techpro education ana sayfasina git
            driver.get("https://www.techproeducation.com");
            waitFor(3);
//        Arama kutusuna QA yaz
            typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");
        }
    }

