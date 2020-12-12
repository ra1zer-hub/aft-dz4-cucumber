package ru.appline.framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CreditCompleteHousePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'input-container-4-8-0')]")
    private List<WebElement> mortgageCalculationFields;

    @FindBy(xpath = "//iframe[(@id='iFrameResizer0')]")
    private WebElement iframe;

    @FindBy(xpath = "//div[@data-test-id='discounts']/div/div/div")
    private List<WebElement> additionalServices;

    @FindBy(xpath = "//div[@data-test-id='main-results-block']//li[not (@data-e2e-id)]")
    private List<WebElement> validatedFields;

    @FindBy(xpath = "//div[@data-test-id='main-results-block']//span[contains(@data-e2e-id,'monthly-payment')]/span")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//h2[text()='\u200BРассчитайте ипотеку']")
    private WebElement visibilityOfCheckedFields;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/discounts-block']")
    private WebElement visibilityOfAdditionalServices;

    public CreditCompleteHousePage fillField(String nameField, String value) {
        scrollToElementJs(iframe);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        double currentPayment = getNumberFromWebElement(monthlyPayment);
        for (WebElement field : mortgageCalculationFields) {
            if (field.getAttribute("textContent").equalsIgnoreCase(nameField)) {
                fillInputField(field, value);
                updateInfo(monthlyPayment, currentPayment);
                returnDefaultFrame();
                return this;
            }
        }
        fail("Поле с наименованием '" + nameField + "' отсутствует на странице 'Ипотека на готовое жилье'");
        return this;
    }

    public CreditCompleteHousePage installationOfAdditionalServices(String nameField, String value) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        scrollToElementJs(visibilityOfAdditionalServices);
        double currentPayment = getNumberFromWebElement(monthlyPayment);
        for (WebElement field : additionalServices) {
            if (field.getAttribute("innerText").toLowerCase().contains(nameField.toLowerCase())) {
                checkAdditionalOptions(field, value);
                updateInfo(monthlyPayment, currentPayment);
                returnDefaultFrame();
                return this;
            }
        }
        fail("Доп. услуга '" + nameField + "' отсутствует на странице 'Ипотека на готовое жилье'");
        return this;
    }

    public CreditCompleteHousePage checkValueField(String nameField, String value) {
        scrollToElementJs(visibilityOfCheckedFields);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        for (WebElement validatedField : validatedFields) {
            WebElement nameValidatedField = validatedField.findElement(By.xpath("./span"));
            if (nameValidatedField.getText().equalsIgnoreCase(nameField)) {
                WebElement valueValidatedField = validatedField.findElement(By.xpath("./span/span"));
                assertEquals("В поле с именем '" + nameField + "' текущее значение отличается от ожидаемого",
                        value, valueValidatedField.getText());
                returnDefaultFrame();
                return this;
            }
        }
        fail("Поле с наименованием '" + nameField + "' отсутствует в калькуляторе ипотеки");
        return this;
    }

}