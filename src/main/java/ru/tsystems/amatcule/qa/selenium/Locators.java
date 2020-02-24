package ru.tsystems.amatcule.qa.selenium;

import org.openqa.selenium.By;

public class Locators {

    //LoginForm
    public static final By USERNAME_INPUT = By.cssSelector("form#loginform input#UserName");
    public static final By PASSWORD_INPUT = By.cssSelector("form#loginform input[type=password]");
    public static final By LOGON_BUTTON_LOCATOR = By.cssSelector("form#loginform input[type=submit]");
    public static final By REMEMBER_ME_CHECKBOX_LOCATOR = By.cssSelector("form#loginform input#RememberMe");

    //dashboards
    public static final By MEGABYTES_TEXT_LOCATOR = By.cssSelector("div[data-name='pryaniky/virtcurrency'] span[data-bind*='mythanksCount']");
    public static final By LOGGED_USER_PHOTO_LOCATOR = By.cssSelector("img[class='logged-user-photo']");
    public static final By POST_NEWS_TEXTAREA_LOCATOR = By.xpath("//div[@id='postElem']//textarea");
    public static final By POST_NEWS_BUTTON_LOCATOR = By.xpath("//div[@id='postElem']//input[@class='postNewsButton btn']");
    public static final By MEGABYTE_TAB_LOCATOR = By.xpath("//span[text()='Мегабайт']//ancestor::a");
    public static final By MEGABYTE_COLLEAGUE_SELECT_LOCATOR = By.xpath("//div[@id='postElem']//div[@class='pryanikyPostType']//li[@class='select2-search-field']//input");
    public static final By MEGABYTE_TEXT_LOCATOR = By.xpath("//div[@id='postElem']//textarea");
    public static final By MEGABYTE_SEND_BUTTON_LOCATOR = By.xpath("//div[@id='postElem']//input[@class='postNewsButton btn']");

}
