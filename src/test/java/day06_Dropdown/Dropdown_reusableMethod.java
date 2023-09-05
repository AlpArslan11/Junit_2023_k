package day06_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dropdown_reusableMethod {

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
}
