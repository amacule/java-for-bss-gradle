package ru.tsystems.amatcule.qa.selenium;

import org.openqa.selenium.By;

public class Locators {
    public static final By USERNAME_INPUT = By.cssSelector("form#loginform input#UserName");
    public static final By PASSWORD_INPUT = By.cssSelector("form#loginform input[type=password]");
    public static final By LOGON_BUTTON_LOCATOR = By.cssSelector("form#loginform input[type=submit]");

    public static final By MEGABYTES_TEXT_LOCATOR = By.cssSelector("div[data-name='pryaniky/virtcurrency'] span[data-bind*='mythanksCount']");
}
