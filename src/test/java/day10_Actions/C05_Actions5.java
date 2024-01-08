package day10_Actions;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;





public class C05_Actions5 extends TestBase1 {

    @Test
    public void asd() throws InterruptedException {


        Actions actions = new Actions(driver);
        //actions.moveToElement();
        //actions.moveToLocation()
        //actions.scrollByAmount()
        //actions.scrollToElement()
        driver.get("https://www.amazon.com/");

        WebElement accountListButton = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        WebElement allDdm = driver.findElement(By.id("searchDropdownBox"));
        WebElement signInButtom = driver.findElement(By.xpath("(//*[contains(.,'    Back to top')])[5]"));

        actions.moveToElement(accountListButton).perform();

        Thread.sleep(2000);
     //   actions.moveToLocation(230,28).perform();


   //     actions.scrollByAmount(100,0).perform();
        actions.scrollToElement(signInButtom).perform();
        Thread.sleep(2000);



    }



}
