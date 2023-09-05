package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C02_Actions2 extends TestBase1 {

    @Test
    public void hoverOverActionsTest(){

        //Class: Actions2
        //Method : hoverOver() and test the following scenario:
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com");
        waitFor(8);

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        Actions actions = new Actions(driver);
        WebElement accountListsButton = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListsButton).perform();

        //“Account” secenegine tikka
        WebElement accountButton = driver.findElement(By.xpath("//*[.='Account'] "));
        actions.click(accountButton).perform();


        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        String actualtitleText = driver.findElement(By.xpath("//h1[contains(.,'Your Account')]")).getText();
        String exptectedTitle = "Your Account";

        Assert.assertEquals(exptectedTitle,actualtitleText);


    }



}
