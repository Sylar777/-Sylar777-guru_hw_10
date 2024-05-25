package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class RepositorySteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repository);
        $("#query-builder-test").pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repository}")
    public void clickRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void checkIssueExist(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
