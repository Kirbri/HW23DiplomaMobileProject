package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class AnnouncementPage {
    final SelenideElement titleAnnouncement = $(id("com.avito.android:id/advert_details_title")),
            callButton = $("[text='Позвонить']"),
            writeButton = $("[text='Написать']"),
            profileButton = $(id("com.avito.android:id/contacts_container")).$(id("com.avito.android:id/title"));

    public static String sellerName = "";

    private SelenideElement scrollToElement(String value) {
        return $(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"" + value + "\"));"
        ));
    }

    @Step("Проверить название объявления")
    public AnnouncementPage checkTitleAnnouncement(String value) {
        titleAnnouncement.shouldHave(text(value));
        return this;
    }

    @Step("Позвонить продавцу по объявлению")
    public AnnouncementPage callTheSeller() {
        if (callButton.exists()) {
            callButton.click();
        } else {
            System.out.println("Нет возможности позвонить! Пользователю можно только написать!");
        }
        return this;
    }

    @Step("Написать продавцу по объявлению")
    public AnnouncementPage writeToTheSeller() {
        if (writeButton.exists()) {
            writeButton.click();
        } else {
            System.out.println("Нет возможности написать! Пользователю можно только позвонить!");
        }
        return this;
    }

    @Step("Отправить базовый вопрос продавцу")
    public AnnouncementPage sendMessageToSeller() {
        scrollToElement("com.avito.android:id/design_input_right_icon").click();
        return this;
    }

    @Step("Перейти в профиль продавца")
    public AnnouncementPage goToSellerProfile() {
        profileButton.click();
        return this;
    }

    @Step("Подписаться на продавца")
    public AnnouncementPage subscribeToSeller() {
        scrollToElement("com.avito.android:id/subscribe").click();
        return this;
    }

    @Step("Пожаловаться на объявление")
    public AnnouncementPage reportAnnouncement() {
        scrollToElement("com.avito.android:id/btn_abuse").click();
        return this;
    }

    @Step("Проверить можно ли зайти в профиль и посмотреть все объявления")
    public AnnouncementPage saveNameOfSeller() {
        if (scrollToElement("com.avito.android:id/summary").exists()) {
            sellerName = profileButton.text();
        }
        return this;
    }
}