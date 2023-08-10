package Alparslan.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C01_Actions5 extends TestBase1 {



    @Test
    public void shiftTusunaBasarakYazma(){


        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK) Ve ENTER tusuna bas


        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        actions.keyDown(searchBox,Keys.SHIFT)
                .sendKeys( "iPhone X fiyatlari")
                .keyUp(Keys.SHIFT)
                .sendKeys("  cok pahali!" + Keys.ENTER + Keys.ZENKAKU_HANKAKU)
                .build()
                .perform();

        waitFor(3);





    }

}
