package ru.appline.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static ru.appline.framework.managers.InitManager.initFramework;
import static ru.appline.framework.managers.InitManager.quitFramework;

public class Hooks {

    @Before
    public void beforeAll() {
        initFramework();
    }

    @After
    public void afterAll() {
        quitFramework();
    }
}