package ru.appline.framework.utils;

import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;

import java.io.ByteArrayInputStream;

public class MyAllureListener extends AllureCucumber5Jvm {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if (testStepFinished.getResult().getStatus().equals(Status.FAILED)) {
                Allure.attachment("Screenshot", new ByteArrayInputStream(addScreenshot()));
            }
        });
        super.setEventPublisher(publisher);
    }
}
