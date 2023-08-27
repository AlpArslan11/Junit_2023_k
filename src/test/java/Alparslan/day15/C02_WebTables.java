package Alparslan.day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

import java.util.List;

public class C02_WebTables extends TestBase1 {
//    https://the-internet.herokuapp.com/tables
//    Create a class: WebTables
//    Task 1 : Table1’i print edin
//    Task 2 : 3. Row’ datalarını print edin
//    Task 3 : Son row daki dataları print edin
//    Task 4 : 5. Column datalarini print edin
//    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin


    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());
    @Test
    public void table1Print(){
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        logger.info("TABLE 1 VERİLERİ");
        System.out.println(table1);
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));

//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMBDA
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }
    }
    @Test
    public void row3Print(){
        //    Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(veri-> System.out.println(veri.getText()));
    }


    //    Task 3 : Son row daki dataları print edin
    @Test
    public void sonSatirVerileri(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));
    }
    //    Task 4 : 5. Column datalarini print edin
    @Test
    public void sutun5Test(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri-> System.out.println(veri.getText()));
    }

    @Test
    public void printDataTest() {
//    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
        driver.get("https://the-internet.herokuapp.com/tables");
        rowColumnDataPrint(2,3);

    }
    public void rowColumnDataPrint(int rowNumber, int columnNumber){
            String rowData=    driver.findElement(By.xpath("//table[@id='table1']//tr["+rowNumber+"]//td["+columnNumber+"]")).getText();
            System.out.println("rowData = " + rowData);
    }
}

