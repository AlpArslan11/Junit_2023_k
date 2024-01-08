package day06_Dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;

import java.util.List;

public class C03_DropDown extends TestBase1 {

    @Test
    public void ddm(){
        driver.get("https://www.amazon.com/");
        WebElement ddmAmazon = driver.findElement(By.id("searchDropdownBox"));


        Select select = new Select(ddmAmazon);
        System.out.println("secili metni almak için select.getFirstSelectedOption() -> " + select.getFirstSelectedOption().getText());
        System.out.println("---------------------------------------------------------");
        System.out.println(" tum seçili ddm elementlerini dondurur -> select.getAllSelectedOptions()");
        List<WebElement> ddmSeciliElementler = select.getAllSelectedOptions();

        for (WebElement e: ddmSeciliElementler
             ) {
            System.out.println(e.getText());
        }


        System.out.println("-----------------------------------------------------------------");
        System.out.println("DDM DE VAR OLAN TUM ELEMENTLERİ DONDURMEK İCİN select.getOptions()");
        List<WebElement> ddmici = select.getOptions();

        for (WebElement e: ddmici
             ) {
            System.out.println(e.getText());
        }




    }


}
