package ru.appline.framework.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.managers.DriverManager.quitDriver;
import static ru.appline.framework.utils.PropConst.*;

public class InitManager {

    public static PropManager prop = PropManager.getPropManager();


    public static void initFramework() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        getDriver().get(prop.getProperty(APP_URL));
    }

    public static void quitFramework() {
        quitDriver();
    }
}
