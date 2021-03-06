package ru.tsystems.amatcule.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class AbstractBaseSeleniumTest {
    public static ThreadLocal <WebDriver> webDriver = ThreadLocal.withInitial(()->null);
    //protected WebDriver webDriver;

    private static final URL HUB_URL;

    static {
        try {
            HUB_URL = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Incorrect Selenium HUB_URL ", e);
        }
    }

    protected WebDriver getDriver(){
        return webDriver.get();
    }

    @BeforeMethod
    public void initWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        webDriver.set(new RemoteWebDriver(HUB_URL, chromeOptions));
        getDriver().manage().timeouts().implicitlyWait(20,SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(20,SECONDS);
    }

    @AfterMethod
    public void closeWebDriver() {
        if (getDriver() != null) {
            getDriver().close();
        }
    }

    protected void pause() {
        try {
            Thread.sleep(SECONDS.toMillis(5));
        } catch (InterruptedException ignored) {
            pause();
        }
    }
}
