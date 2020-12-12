package ru.appline.framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"ru.appline.framework.utils.MyAllureListener",
                "progress",
                "summary"},
        glue = {"ru.appline.framework.steps"},
        features = {"src/test/resources/"},
        tags = "@cucumberTest"
)
public class CucumberRunner {
}
