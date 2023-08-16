package Alparslan.day09;


import org.junit.Test;

import org.openqa.selenium.Cookie;
import utilities1.TestBase1;

import java.util.Set;


public class C04_Cookeies extends TestBase1 {
    /*
    10. Session Selenium Multiple Windows İ Basic Authentication0501      2:06:22
     */


    @Test
    public void handleCookiesTest(){
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(8);

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("amazonda " + allCookies.size() + " adet cookie var");

        //3. Bir Cookie yi İsmiyle bul



        //--> Tüm cookie'leri yazdıralim
         //allCookies.stream().forEach(t-> System.out.println(t.getName()));
        for (Cookie e : allCookies){
            System.out.println("COOKIE --> " + e); // Cookinin tamamını yazdık
            System.out.println("Cookie isimleri --> " + e.getName()); // sadece cookie isimlerini aldim
        }

        System.out.println("\nCookie'yi ismi ile bulma - cagırma" +driver.manage().getCookieNamed("sp-cdn"));


        waitFor(2);

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam","antepFıstıklı-Cikolata");
        driver.manage().addCookie(favoriCookiem);

        System.out.println("\nYeni cookie Sayisi -> " + driver.manage().getCookies().size());


        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("skin");

        //6. Tum cookie leri si
        driver.manage().deleteAllCookies();
        System.out.println("\nTUM COOKIES LERI SILDIM. YENI COOKIE SAYISI " + driver.manage().getCookies().size());
        driver.close();
    }


}
