package Alparslan.day13;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities1.TestBase1;

public class C02_TimeOutException extends TestBase1 {

    /*
   *********** TimeOutException explicit wait kullandıgımda ve locator bulunamadiğinda alirim.
     */





    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com");
    //    Explicit wait icin olusturdugumuz methodlardan birini kullanalim
    //    Parametre 1: beklemek istedigim element, Parametre 2: Max sure
        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
                .sendKeys("QA"+ Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
//


    }
}
