package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SystemNotificationsPage {

    final SelenideElement dontAllowButton = $(id("com.android.permissioncontroller:id/permission_deny_button"));

    @Step("Кнопка 'Don’t allow' для уведомлений")
    public SystemNotificationsPage closeNotifications() {
        dontAllowButton.click();
        return this;
    }
}