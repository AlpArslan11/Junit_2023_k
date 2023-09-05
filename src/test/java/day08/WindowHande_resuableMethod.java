package day08;

import utilities1.TestBase1;

import java.util.ArrayList;
import java.util.List;

public class WindowHande_resuableMethod extends TestBase1 {

    //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet") The internet baslikli sayfaya gider
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }

         //    windowNumber sıfır (0)'dan başlıyor.
        //    index numarasini parametre olarak alir
        //    ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }


}
