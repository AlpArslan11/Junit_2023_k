package Alparslan.day18;

import org.junit.Test;
import utilities1.TestBase1;

public class C01_JSExecutor_GetValue extends TestBase1 {

    //  1)getValueTest metotu olustur
//	2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır
    @Test
    public void getValueTest(){
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");
    }
}