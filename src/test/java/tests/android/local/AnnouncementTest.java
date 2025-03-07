package tests.android.local;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.avito.*;
import tests.TestBase;

@Feature("Selenide-appium local Android tests")
@Tag("local")
@Tag("localAnnouncementTests")
public class AnnouncementTest extends TestBase {
    final MainPage mainPage = new MainPage();
    final AnnouncementPage announcementPage = new AnnouncementPage();
    final PopUpNotificationPage popUpNotificationPage = new PopUpNotificationPage();
    final ProfilePage profilePage = new ProfilePage();
    final ComplaintPage complaintPage = new ComplaintPage();

    @Test
    @DisplayName("Открыть первое объявление и проверить совпадение названий")
    void openFirstAnnouncementAndCheckTitleTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement);
    }

    @Test
    @DisplayName("Открыть первое объявление и позвонить по нему")
    void unsuccessfulCallTheSellerNeedRegistrationTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .callTheSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и написать по нему")
    void unsuccessfulWriteTheSellerNeedRegistrationTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .writeToTheSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
//    @Disabled("Не работает scroll")
    @DisplayName("Открыть первое объявление и отправить базовый вопрос продавцу")
    void unsuccessfulAskTheSellerNeedRegistrationTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .sendMessageToSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и перейти к профилю продавца")
    void unsuccessfulGoToSellerProfileTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
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
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .subscribeToSeller();
        popUpNotificationPage.checkFormLoginOrRegister();
    }

    @Test
    @DisplayName("Открыть первое объявление и пожаловаться на него")
    void reportAnnouncementTest() {
        mainPage.closeTopHint()
                .saveFirstAnnouncement()
                .openFirstAnnouncement();
        announcementPage.checkTitleAnnouncement(MainPage.nameOfAnnouncement)
                .reportAnnouncement();
        complaintPage.reportPage()
                .reportCategoriesMoreThen0();
    }
}