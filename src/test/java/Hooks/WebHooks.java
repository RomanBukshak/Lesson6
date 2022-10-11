package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class WebHooks {
    @Before
    public void setUp(){
        Configuration.startMaximized = true;
    }

    @After
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }

}