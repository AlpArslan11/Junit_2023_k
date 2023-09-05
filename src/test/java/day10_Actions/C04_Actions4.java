package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C04_Actions4 extends TestBase1 {

    @Test
    public void dragAndDropTest(){
        //Class: Action4
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        Actions actions = new Actions(driver);

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        waitFor(2);

        actions.dragAndDrop(source,target).perform();
        waitFor(3);
        driver.switchTo().parentFrame();
    }



    @Test
    public void clickAndHold(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        Actions actions = new Actions(driver);

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        waitFor(2);

        actions
                .clickAndHold(source)
                .moveToElement(target)
                .release() // tuşu sal, bırak.
                .build() // onceki methodlari birbirine bağla. Hata alınmasını azaltır. KULLANILMASI TERCİH EDILIR
                .perform();

      //  actions.click(target).perform();
        waitFor(3);
        driver.switchTo().parentFrame();
    }

        @Test
    public void moveByOffSetTest(){
            //Given user is on https://jqueryui.com/droppable/
            driver.get("https://jqueryui.com/droppable/");

            //And user moves the target element(Drag me to my target) in to destination(Drop here)
            Actions actions = new Actions(driver);

            driver.switchTo().frame(0);
            WebElement source = driver.findElement(By.id("draggable"));

            actions
                    .clickAndHold(source).
                    moveByOffset(430,30)
                    .release()
                    .build()
                    .perform();


            waitFor(3);
            driver.switchTo().parentFrame();

        }




}
