package ru.tsystems.amatcule.qa.allure;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.tsystems.amatcule.qa.selenium.AbstractBaseSeleniumTest;

public class StepLogger implements StepLifecycleListener {
    @Override
    public void afterStepStop(io.qameta.allure.model.StepResult result) {
        byte[] bytes = ((TakesScreenshot) AbstractBaseSeleniumTest.webDriver.get()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(bytes);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}