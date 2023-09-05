package day13_Exceptions;

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

        driver.
                findElement(By.xpath("//*[@type='search']")) //org.openqa.selenium.NoSuchElementException:
                .sendKeys("QA" + Keys.ENTER);


    }


}
