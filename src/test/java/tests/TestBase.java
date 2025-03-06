package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.AttachHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.avito.SystemNotificationsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {
    static final SystemNotificationsPage systemNotificationsPage = new SystemNotificationsPage();
    static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {

        if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        if (deviceHost.equals("emulation")) {
            Configuration.browser = LocalDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
        step("Отклонение уведомлений по определению геопозиции и отправке уведомлений", () -> {
            systemNotificationsPage.closeNotifications();
            systemNotificationsPage.closeNotifications();
        });
    }

    @AfterEach
    void addAttachments() {
        String sessionId = "";
        if (deviceHost.equals("browserstack")) {
            sessionId = Selenide.sessionId().toString();
        }
        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();
        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            AttachHelper.addVideo(sessionId);
        }
    }
}