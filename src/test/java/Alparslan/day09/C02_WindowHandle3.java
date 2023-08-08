package Alparslan.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities1.TestBase1;

public class C02_WindowHandle3 extends TestBase1 {

    /*
    Selenium 4 ile gelmiştir.
     driver.switchTo().newWindow(WindowType.TAB); --> TAB yeni sekme acar.
      driver.switchTo().newWindow(WindowType.WINDOW); ---> WINDOW yeni pencere açar
     */

    @Test
    public void newWindowHandleTest(){
        // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
        String techproWindowHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("TechPro Education"));

        // 2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
         waitFor(3);
         driver.switchTo().newWindow(WindowType.TAB); // yeni pencere oluşturur ve oraya geçiş yapar
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


        // 3.  Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini  icerdigini test edin
        waitFor(2);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        waitFor(8);

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);

        // techpro sayfasına gitmek için driver.switchTo().window(techproHandle)
        driver.switchTo().window(techproWindowHandle);
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("TechPro Education"));
        waitFor(3);

    }

}
