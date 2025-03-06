package screens.avito;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;

public class ComplaintPage {
    final ElementsCollection reportTitle = $$(className("android.widget.TextView"));

    @Step("Проверить открытие страницы 'Жалоба'")
    public ComplaintPage reportPage() {
        reportTitle.last().shouldHave(text("Жалоба"));
        return this;
    }

    @Step("Проверить что количество категорий больше 0")
    public ComplaintPage reportCategoriesMoreThen0() {
        reportTitle.shouldBe(sizeGreaterThan(0));
        return this;
    }
}