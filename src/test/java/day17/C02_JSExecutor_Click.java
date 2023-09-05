package day17;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

import java.util.Set;


public class C02_JSExecutor_Click extends TestBase1 {

        @Test
        public void clickByJSTest(){
            //    Techpro education ana sayfasina git
            driver.get("https://www.techproeducation.com");
            waitFor(3);

            String actualWindowHandle = driver.getWindowHandle();
            //    LMS LOGIN elementine tikla
            clickByJS(driver.findElement(By.linkText("LMS")));
            //    Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
            waitFor(3);

            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String e : allWindowHandles){
                if (!e.equals(actualWindowHandle)){
                    driver.switchTo().window(e);
                    break;
                }
            }



            Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
        }
    }
