package ru.appline.framework.managers;

import ru.appline.framework.Pages.CreditCompleteHousePage;
import ru.appline.framework.Pages.StartPage;

public class PagesManager {

    private static PagesManager pagesManager;
    StartPage startPage;
    CreditCompleteHousePage creditCompleteHousePage;

    private PagesManager() {
    }

    public static PagesManager getManagerPages() {
        if (pagesManager == null) {
            pagesManager = new PagesManager();
        }
        return pagesManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public CreditCompleteHousePage getCreditCompleteHousePage() {
        if (creditCompleteHousePage == null) {
            creditCompleteHousePage = new CreditCompleteHousePage();
        }
        return creditCompleteHousePage;
    }
}
