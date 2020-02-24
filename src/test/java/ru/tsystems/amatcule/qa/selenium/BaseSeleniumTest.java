package ru.tsystems.amatcule.qa.selenium;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;


public class BaseSeleniumTest extends AbstractBaseSeleniumTest {

    public String url="https://www.swtestacademy.com/selenium-webdriver-tutorial-java-testng/";
    //public final String START_PAGE_URL="https://www.swtestacademy.com/selenium-webdriver-tutorial-java-testng/";
    public static final String START_PAGE_URL = "https://intra.t-systems.ru/dash";
    //public static final
    public static final String USERNAME = System.getenv("TEST_USERNAME");
    public static final String PASSWORD = System.getenv("TEST_PASSWORD");

    @Test
    public void testEquals(){
        int expVal = 6;
        int actVal = 0;
        int x = 2;
        actVal = x + x * x;
        assertEquals(expVal,actVal,"Не равно");
    }

    @Test
    public void testNavigate(){
        getDriver().navigate().to(url);

    }

    @Test
    public void intraTest(){
        getDriver().get(START_PAGE_URL);
        var title = getDriver().findElement(By.cssSelector("h3")).getText();
        assertThat("Login page is not open", title, is("Добро пожаловать в Intra"));
        var userNameInput = getDriver().findElement(Locators.USERNAME_INPUT);
        userNameInput.sendKeys(USERNAME);
        var passwordInput = getDriver().findElement(Locators.PASSWORD_INPUT);
        passwordInput.sendKeys(PASSWORD);
        var loginButton = getDriver().findElement(Locators.LOGON_BUTTON_LOCATOR);
        loginButton.click();
        String currentUrl = getDriver().getCurrentUrl();
        assertThat("Redirect or login is not working properly", currentUrl, is(START_PAGE_URL));

        var wait = new WebDriverWait(getDriver(), SECONDS.toSeconds(60),SECONDS.toMillis(1));
        WebElement megabyteTextBlock = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.MEGABYTES_TEXT_LOCATOR));
        var megabyte = Integer.parseInt(megabyteTextBlock.getText());
        assertThat(megabyte, Matchers.is(greaterThan(100)));
        //assertThat("Redirect or login not working", driver.getCurrentUrl(), is(START_PAGE_URL));
        //WebDriverWait wait = new WebDriverWait(webDriver, TimeUnit.SECONDS.toSeconds(60),TimeUnit.SECONDS.toMillis(1));
        //WebElement megabyteTextBlock = wait.until(presenceOfElementLocated(Locators.USERNAME_INPUT));
    }

    @Test
    public void task21Test(){
        getDriver().get(START_PAGE_URL);
        var title = getDriver().findElement(By.cssSelector("h3")).getText();
        assertThat("Login page is not open", title, is("Добро пожаловать в Intra"));
        var userNameInput = getDriver().findElement(Locators.USERNAME_INPUT);
        userNameInput.sendKeys(USERNAME);
        var passwordInput = getDriver().findElement(Locators.PASSWORD_INPUT);
        passwordInput.sendKeys(PASSWORD);
        var loginButton = getDriver().findElement(Locators.LOGON_BUTTON_LOCATOR);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), TimeUnit.SECONDS.toSeconds(60),TimeUnit.SECONDS.toMillis(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.LOGGED_USER_PHOTO_LOCATOR));
        var loggedUserPhoto = getDriver().findElement(Locators.LOGGED_USER_PHOTO_LOCATOR);
        loggedUserPhoto.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.USER_SETTINGS_LINK_LOCATOR));
        var userSettingsLink = getDriver().findElement(Locators.USER_SETTINGS_LINK_LOCATOR);
        userSettingsLink.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ABOUT_TEXTAREA_LOCATOR));
        var aboutTextarea = getDriver().findElement(Locators.ABOUT_TEXTAREA_LOCATOR);
        aboutTextarea.clear();
        aboutTextarea.sendKeys("Я изучаю Java и Selenium");
        var saveButton = getDriver().findElement(Locators.SAVE_BUTTON_LOCATOR);
        saveButton.click();
        getDriver().navigate().refresh();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ABOUT_TEXTAREA_LOCATOR));
        aboutTextarea = getDriver().findElement(Locators.ABOUT_TEXTAREA_LOCATOR);
        assertThat("Info hasn't saved",aboutTextarea.getText(),is("Я изучаю Java и Selenium"));
    }
}
