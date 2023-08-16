package Alparslan.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class Homework_01 extends TestBase1 {

    // Keyboard Base Actions
    //Homework
    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2- Hover over Me First" kutusunun ustune gelin
    //3. Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void hoveroverTest01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMe = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMe).perform();

    //hoverOverOnElementActions(hoverOverMe)

        //3. Link 1" e tiklayin
        driver.findElement(By.xpath("//*[.='Link 1']")).click();
        waitFor(2);

        //4. Popup mesajini yazdirin

        System.out.println("Pop Up yazısı --> " + driver.switchTo().alert().getText());


        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        //6. “Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.id("click-box"))).build().perform();
        waitFor(2);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold yazısı --> "
                + driver.findElement(By.xpath("//*[contains(text(),'Well done')]")).getText());
        actions.release().perform();
        waitFor(2);

        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[contains(text(),'Double C')]")));
        waitFor(5);

    }

}
