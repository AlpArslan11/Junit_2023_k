package day06_AhmetB;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownReusableMethod {

    WebDriver driver;

    @Before
    public void setUp() {
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    // Dropdown için reusable method olusturalim
    public void selectFromDropdown(WebElement dropdown, String secenek){

        //gonderilen dropdown Webelementinin tüm dropdown optionlari alınır.Tum option tagname'e sahip ne varsa alır.
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for (WebElement e : options){
            if (e.getText().equals(secenek)){
                e.click();
                break;
            }
        }


    }

    @Test
    public void reusableMethodKullan(){
        // dropdown reusable method ile yılı 2005 seçelim month november day 5
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        selectFromDropdown(year,"2005");
        selectFromDropdown(month,"November");
        selectFromDropdown(day,"5");

        /* YA DA
        selectFromDropdown(driver.findElement(By.xpath("//*[@id='year']")),"2005");
        selectFromDropdown(driver.findElement(By.id("month")),"November");
        selectFromDropdown(driver.findElement(By.id("day")),"5");
        */


    }

    @Test
    public void resuable2(){

    }

}
