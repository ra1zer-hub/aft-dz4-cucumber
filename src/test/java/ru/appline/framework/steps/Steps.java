package ru.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.framework.managers.PagesManager;

public class Steps {

    private PagesManager app = PagesManager.getManagerPages();

    @Когда("^Загружена стартовая страница$")
    public void getInitialPage() {
        app.getStartPage();
    }

    @Когда("^Закрываем cookie баннер$")
    public void closeCookieBanner() {
        app.getStartPage().closeCookieContent();
    }

    @Когда("^Переход в главное меню '(.*)'$")
    public void selectNameBaseMenu(String nameBaseMenu) {
        app.getStartPage().selectBaseMenu(nameBaseMenu);
    }

    @Когда("^Выбираем подменю '(.*)'$")
    public void selectNameSubMenu(String nameSubMenu) {
        app.getStartPage().selectSubMenu(nameSubMenu);
    }

    @Когда("^Заполняем поле значением$")
    public void fillFields(DataTable dataTable){
        dataTable.cells().forEach(
                raw -> {
                    app.getCreditCompleteHousePage().fillField(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("^Настраиваем дополнительные услуги$")
    public void setUpAdditionalServices(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getCreditCompleteHousePage().installationOfAdditionalServices(raw.get(0), raw.get(1));
                }
        );
    }

    @Тогда("^Проверяем значение полей$")
    public void checkValueField(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getCreditCompleteHousePage().checkValueField(raw.get(0), raw.get(1));
                }
        );
    }
}
