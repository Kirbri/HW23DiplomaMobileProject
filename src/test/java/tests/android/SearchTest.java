package tests.android;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.MainPage;
import screens.PopUpNotificationPage;
import screens.SearchPage;

@Feature("Mobile Android Search tests")
@Tag("searchTests")
public class SearchTest extends TestBase {
    final MainPage mainPage = new MainPage();
    final SearchPage searchPage = new SearchPage();
    final PopUpNotificationPage popUpNotificationPage = new PopUpNotificationPage();

    @BeforeEach
    void beforeEachCloseHintAndClickSearchBar() {
        mainPage.clickSearchBar();
    }

    @Test
    @DisplayName("Поиск по ключевому слову с нулевым результатом")
    void searchAnnouncementWithResult0Test() {
        mainPage.searchByKeyWord("Скунс трёхцветный")
                .waitFullRequest("Скунс трёхцветный")
                .selectFirstSearchListItem();
        searchPage.checkResultsEquals0();
    }

    @Test
    @DisplayName("Поиск по ключевому слову с не нулевым результатом")
    void searchAnnouncementWithResultGreaterThan0Test() {
        mainPage.searchByKeyWord("Apple 16 Pro Max 1 Tb")
                .waitFullRequest("Apple 16 Pro Max 1 Tb")
                .selectFirstSearchListItem();
        searchPage.checkResultsMore0();
    }

    @Test
    @DisplayName("Поиск по ключевому слову и подписка на поиск")
    void searchAnnouncementAndSubscribeToSearchTest() {
        mainPage.searchByKeyWord("Selenide")
                .waitFullRequest("Selenide")
                .selectFirstSearchListItem();
        searchPage.addSearchToFavorites();
        popUpNotificationPage.checkNameSavedSearchHeaderRoot()
                .clickAtButtonAdd()
                .checkFormLoginOrRegister();
    }
}