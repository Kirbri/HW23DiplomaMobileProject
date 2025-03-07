package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ProfilePage {
    final SelenideElement errorAndProgressContent = $(id("com.avito.android:id/info_message")),
            nameSellerProfile = $(id("com.avito.android:id/name"));

    @Step("Проверить отображение информации о том, что 'Объявления пользователя скрыты'")
    public ProfilePage checkInfoMessage() {
        errorAndProgressContent.shouldHave(text("Объявления пользователя скрыты"));
        return this;
    }

    @Step("Проверить название профиля продавца")
    public ProfilePage checkSellerProfileName() {
        nameSellerProfile.shouldHave(text(AnnouncementPage.sellerName));
        return this;
    }
}