package com.jpetstore.tests;
import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.PropKey;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class MyFirstTest extends DriverManager {

    @Test
    void this_is_my_first_selenium_test() throws InterruptedException {

        String url = prop.getProperty(PropKey.URL.getPropVal());
        String port = prop.getProperty(PropKey.PORT.getPropVal());
        String finalUrl = url + port;

        driver.get(finalUrl);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
}
