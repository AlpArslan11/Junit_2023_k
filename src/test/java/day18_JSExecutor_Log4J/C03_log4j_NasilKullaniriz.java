package day18_JSExecutor_Log4J;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

import java.util.List;

public class C03_log4j_NasilKullaniriz extends TestBase1 {

    private static Logger logger = LogManager.getLogger(C03_log4j_NasilKullaniriz.class.getName());
    @Test
    public void table1Print(){
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        logger.info("TABLE 1 VERİLERİ ____Log4J'den gelen______");
        System.out.println(table1);
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMBDA
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }
    }


}
