package screens.avito;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    final SelenideElement textClueButton = $(id("com.avito.android:id/text_view")),
            titleOfAnnouncement = $(id("com.avito.android:id/mainText")),
            announcementButton = $(id("com.avito.android:id/advert_content")),
            searchBar = $(id("com.avito.android:id/input_view")),
            editTextBar = $(className("android.widget.EditText")),
            suggestedTitle = $(id("com.avito.android:id/suggest_title")),
            searchViewItem = $(id("com.avito.android:id/search_view_item"));

    public static String nameOfAnnouncement;

    @Step("Закрыть подсказку в верхней части экрана")
    public MainPage closeTopHint() {
        textClueButton.click();
        return this;
    }

    @Step("Сохранить название первого объявления")
    public MainPage saveFirstAnnouncement() {
        nameOfAnnouncement = titleOfAnnouncement.text();
        return this;
    }

    @Step("Открыть первое объявление")
    public MainPage openFirstAnnouncement() {
        announcementButton.click();
        return this;
    }

    @Step("Открыть поле ввода для поиска")
    public MainPage clickSearchBar() {
        searchBar.click();
        return this;
    }

    @Step("Поиск по ключевому слову {value}")
    public MainPage searchByKeyWord(String value) {
        editTextBar.sendKeys(value);
        return this;
    }

    @Step("Дождаться появления полного поискового запроса в предложенной строке поиска")
    public MainPage waitFullRequest(String value) {
        suggestedTitle.shouldHave(Condition.text(value.toLowerCase()));
        return this;
    }

    @Step("Выбрать первый предложенный вариант категории поиска")
    public MainPage selectFirstSearchListItem() {
        searchViewItem.click();
        return this;
    }
}