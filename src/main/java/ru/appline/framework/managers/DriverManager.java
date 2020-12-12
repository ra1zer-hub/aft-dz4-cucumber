package ru.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.appline.framework.utils.PropConst.*;

public class DriverManager {

    private static WebDriver driver;
    private static PropManager prop = PropManager.getPropManager();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        if (prop.getProperty(TYPE_BROWSER).equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty(PATH_GEKO_DRIVER));
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", prop.getProperty(PATH_CHROME_DRIVER));
            driver = new ChromeDriver();
        }
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
