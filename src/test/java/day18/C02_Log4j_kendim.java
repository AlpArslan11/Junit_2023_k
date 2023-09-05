package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4j_kendim {

    //2. Class olustur: Log4j

    //3. Logger object olustur:
    //  --->   private static Logger logger = LogManager.getLogger(Demo1.class.getName());

    //4. Logger fonksiyonuyla istenilen fonksiyonu kullan
    // logger.debug("Debug logger");
    // logger.info("Info logger");
    // logger.error("Error logger");
    // logger.fatal("Fatal logger");
    //5. Consoldeki loglari kontrol edelim. Default olarak error or fatal gorunmus olacaktır

    private static Logger logger = LogManager.getLogger(C02_Log4j_kendim.class.getName());

    @Test
    public void log4jTest(){
        logger.fatal("fatal log!");
        logger.error("Error log!");
        logger.warn("Warn Log!");
        logger.debug("Debug!");
        logger.info("Info Log!");
    }


}
