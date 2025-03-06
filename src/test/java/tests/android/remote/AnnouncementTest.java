package tests.android.remote;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.avito.*;
import tests.TestBase;

@Feature("Selenide-appium remote Android tests")
@Tag("announcementTests")
@Tag("browserstack")
public class AnnouncementTest extends TestBase {
    final MainPage mainPage = new MainPage();
    final AnnouncementPage announcementPage = new AnnouncementPage();
    final PopUpNotificationPage popUpNotificationPage = new PopUpNotificationPage();
    final ProfilePage profilePage = new ProfilePage();
    final ComplaintPage complaintPage = new ComplaintPage();

    @Test
    @DisplayName("Открыть первое объявление и проверить совпадение названий")
    void openFirstAnnouncementAndCheckTitleTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement);
    }

    @Test
    @Disabled("Не находит нужную кнопку")
    @DisplayName("Открыть первое объявление и позвонить по нему")
    void unsuccessfulCallTheSellerNeedRegistrationTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .callTheSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @Disabled("Не находит нужную кнопку")
    @DisplayName("Открыть первое объявление и написать по нему")
    void unsuccessfulWriteTheSellerNeedRegistrationTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .writeToTheSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и отправить базовый вопрос продавцу")
    void unsuccessfulAskTheSellerNeedRegistrationTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .sendMessageToSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и перейти к профилю продавца")
    void unsuccessfulGoToSellerProfileTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .saveNameOfSeller()
                .goToSellerProfile();
        if (AnnouncementPage.sellerName.isEmpty()) {
            profilePage.checkInfoMessage();
        } else {
            profilePage.checkSellerProfileName();
        }
    }

    @Test
    @DisplayName("Открыть первое объявление и подписаться на продавца")
    void unsuccessfulSubscribeToSellerNeedRegistrationTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .subscribeToSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и пожаловаться на него")
    void reportAnnouncementTest() {
        mainPage.saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .reportAnnouncement();
        complaintPage.reportPage()
                .reportCategoriesMoreThen0();
    }
}