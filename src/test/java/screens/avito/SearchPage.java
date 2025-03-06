package screens.avito;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    final SelenideElement nameOfTitle = $(className("android.widget.TextView")),
            notifyOfNewAnnouncementButton = $(id("com.avito.android:id/right_block"));
    final ElementsCollection resultsTableOfAnnouncements = $$(id("com.avito.android:id/advert_grid_root"));

    @Step("Проверить, что количество результатов равно 0")
    public SearchPage checkResultsEquals0() {
        nameOfTitle.shouldHave(text("Ничего не найдено по запросу «скунс трёхцветный»"));
        return this;
    }

    @Step("Проверить, что количество результатов больше 0")
    public SearchPage checkResultsMore0() {
        resultsTableOfAnnouncements.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Подписаться на поиск объявлений по ключевому слову - 'Уведомлять о новых'")
    public SearchPage addSearchToFavorites() {
        notifyOfNewAnnouncementButton.click();
        return this;
    }
}