package day11_JavaFaker_FileExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class Homework_02 extends TestBase1 {
    // 1.Bir Class olusturalim KeyboardActions2
    //2.https://html.com/tags/iframe/ sayfasina gidelim
    //3.video’yu gorecek kadar asagi inin
    //4.videoyu izlemek icin Play tusuna basin
    //5.videoyu calistirdiginizi test edi

    @Test
    public void scrolldownTest(){
        // 1.Bir Class olusturalim KeyboardActions2
        //2.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3.video’yu gorecek kadar asagi inin

        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));

        scrollIntoViewJS(iframe);


            waitFor(2);




        //4.videoyu izlemek icin Play tusuna basin

        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        waitFor(1);



        //5.videoyu calistirdiginizi test edin
       // driver.findElement(By.xpath())

        Assert.assertTrue("video oynatılmıyor",
                driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).isDisplayed());




    }




}
