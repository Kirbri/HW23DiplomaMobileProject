package screens.avito;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class PopUpNotificationPage {
    final SelenideElement loginOrRegisterWindow = $(id("com.avito.android:id/bottom_sheet")),
            savedSearchHeaderRoot = $(id("com.avito.android:id/title"));
    final ElementsCollection buttonAdd = $$(id("com.avito.android:id/text_view"));

    @Step("Появление окна с просьбой регистрации или входа")
    public PopUpNotificationPage checkFormLoginOrRegister() {
        loginOrRegisterWindow.shouldBe(exist);
        return this;
    }

    @Step("Проверить название текста в появившемся окне")
    public PopUpNotificationPage checkNameSavedSearchHeaderRoot() {
        savedSearchHeaderRoot.shouldHave(text("Добавьте поиск в избранное"));
        return this;
    }

    @Step("Нажать на кнопку 'Добавить'")
    public PopUpNotificationPage clickAtButtonAdd() {
        buttonAdd.last().click();
        return this;
    }
}