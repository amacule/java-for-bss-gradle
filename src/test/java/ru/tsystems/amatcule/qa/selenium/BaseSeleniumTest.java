package ru.tsystems.amatcule.qa.selenium;

import org.junit.Test;

import static org.testng.Assert.assertEquals;


public class BaseSeleniumTest {

    @Test
    public void testEquals(){
        int expVal = 6;
        int actVal = 0;
        int x = 2;
        actVal = x + x * x;
        assertEquals(expVal,actVal,"Не равно");
    }
}
