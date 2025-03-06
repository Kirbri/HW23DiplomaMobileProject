package tests.android.remote;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.avito.MainPage;
import screens.avito.PopUpNotificationPage;
import screens.avito.SearchPage;
import tests.TestBase;

@Feature("Selenide-appium remote Android tests")
@Tag("searchTests")
@Tag("browserstack")
public class SearchTest extends TestBase {
    final MainPage mainPage = new MainPage();
    final SearchPage searchPage = new SearchPage();
    final PopUpNotificationPage popUpNotificationPage = new PopUpNotificationPage();

    @Test
    @DisplayName("Поиск по ключевому слову с нулевым результатом")
    void searchAnnouncementWithResult0Test() {
        mainPage.clickSearchBar()
                .searchByKeyWord("Скунс трёхцветный")
                .waitFullRequest("Скунс трёхцветный")
                .selectFirstSearchListItem();
        searchPage.checkResultsEquals0();
    }

    @Test
    @DisplayName("Поиск по ключевому слову с не нулевым результатом")
    void searchAnnouncementWithResultGreaterThan0Test() {
        mainPage.clickSearchBar()
                .searchByKeyWord("Apple 16 Pro Max 1 Tb")
                .waitFullRequest("Apple 16 Pro Max 1 Tb")
                .selectFirstSearchListItem();
        searchPage.checkResultsMore0();
    }

    @Test
    @DisplayName("Поиск по ключевому слову и подписка на поиск")
    void searchAnnouncementAndSubscribeToSearchTest() {
        mainPage.clickSearchBar()
                .searchByKeyWord("Selenide")
                .waitFullRequest("Selenide")
                .selectFirstSearchListItem();
        searchPage.addSearchToFavorites();
        popUpNotificationPage.checkNameSavedSearchHeaderRoot()
                .clickAtButtonAdd()
                .checkFormLoginOrRegister();
    }
}