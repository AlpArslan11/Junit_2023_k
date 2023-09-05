package day13;

public class C05_WebDriverException {


            /*
            WebDriverException
        Driver versiyonları ve browser versiyonları ayni veya yakin olmadiginda alinir
        Driver(Browser) kapattikdan  sonra tekrar kullanmak istediğiniz durumlarda alınabilir.

        ÇÖZÜM
        Framework designinin guzel kurulmuş olması gerekir, ornegin Driver sinifinda birden
        fazLa driver.quit() olmamali

             */


        /*
        SELENİUMDA ALDİĞİM EXCEPTİONLAR
        -- genelde zamanlama wait - yanlış locator ve iframe hataları olabiliyor.

        NoSuchElement --> tekrar locate almayı denerim, locate den eminsem sayfayı bir daha kontrol eder
        refresh yada wait kullanabilirm

        timeoutexception --> genellikle explicit wait kullandiğimda oluyor. adi üzerinde zamanla ile alakali.
        wait'lerdeki zamanlamaları kontrol ederim

        nullpointer exception --> genelde bir şey deklare edilip , tanımlanmadiysa oluyor.
        mesela bir obje ya da değişken deklare ediyorsunuz ama bir değer ataması yapmıyorsunuz.

        stale reference element exception  --> genellikle DOM'da kaybolan elementlerde bu hatayi veriyor.
        mesela sayfa yenileyince locate aldiğimiz elemnti bulamiyor

        webdriverexception webdriver sürüm guncellenmş olabilir. browser guncelleme almış olabilir. driver - browser
        uyumsuzluğunda olur diyebilirz


         */


            /*
            Seleniumda kullandığım waitler çeşit oalrak 2 tane.
            Birisi explicit dğeri implicit. implicit wait genelde broser acilisinda, yani driver kurulumunda kullanıyorum
            bu arada birde javadan wait var onu unuttum.
            explicit wait ise genelde bir elementin yuklenmesi uzun suruyorsa kullanıuyorum. burda da 1 tane fluent wait wardi
            cok kullanmıyorum.
            javadan gelen 1 tane wardi. o da Thread.sleep. bu da kodun calismasini durduruyor. bu da javadan geliyor.
            bunu kullanınca da exception fırlatıyor ama bunu resuable method olarak try catch kullanıyorum.

             */


        /*
        Senkronizasyonm problemlerini nasıl çözersin
        waitleri kullanıyorum. reusuable methodlarinda explicit wait ve implicit wait
         */









}
