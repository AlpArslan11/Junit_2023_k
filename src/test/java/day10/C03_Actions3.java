package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C03_Actions3 extends TestBase1 {

        // JavaScript executer ile scroll down daha cok tercih edilir.
        @Test
        public void scrollUpDown() {

            //Class: ActionClass3
            //Method : scrollUpDown()

            //https://techproeducation.com a git
            driver.get("https://www.techproeducation.com");

            waitFor(3);
            //Sayfanin altına doğru gidelim
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            waitFor(2);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            waitFor(2);
            // ARROW DOWN --> PAGE DOWN'DAN daha az mesafe aldırır
            actions.sendKeys(Keys.ARROW_DOWN).perform();

            waitFor(3);

            //Sonra sayfanın üstüne doğru gidelim

            actions.
                    sendKeys(Keys.PAGE_UP).
                    sendKeys(Keys.PAGE_UP).
                    sendKeys(Keys.PAGE_UP).
                    perform();

            waitFor(3);
        }
}
