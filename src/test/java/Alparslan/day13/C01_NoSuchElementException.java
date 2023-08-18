package Alparslan.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities1.TestBase1;

public class C01_NoSuchElementException extends TestBase1 {



    @Test
    public void NoSuchElementTest(){
        /*
        Techpr
         */

        driver.get("https://www.techproeducation.com");

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA" + Keys.ENTER);


    }


}
