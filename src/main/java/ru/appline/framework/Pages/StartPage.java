package ru.appline.framework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.fail;

public class StartPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link') and @role='button']")
    private List<WebElement> menuBaseList;

    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link_second')]")
    private List<WebElement> menuSubList;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    private WebElement cookieContent;

    @FindBy(xpath = "//div[contains(@class, 'kit-col_xs_12')]/h1")
    private WebElement nextPage;

    @FindBy(xpath = "//div[contains(@class, 'kitt-top-menu__pointer')]")
    private WebElement menuPointer;

    public StartPage closeCookieContent() {
        elementToBeClickable(cookieContent).click();
        return this;
    }

    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().equalsIgnoreCase(nameBaseMenu)) {
                elementToBeClickable(menuItem).click();
                wait.until(ExpectedConditions.visibilityOf(menuPointer));
                return this;
            }
        }
        fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    public CreditCompleteHousePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                elementToBeClickable(menuItem).click();
                wait.until(ExpectedConditions.visibilityOf(nextPage));
                return app.getCreditCompleteHousePage();
            }
        }
        fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getCreditCompleteHousePage();
    }
}
