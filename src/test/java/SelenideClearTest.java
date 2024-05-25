import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideClearTest extends BaseTest{
    @Test
    public void testIssueSearch()
    {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(String.valueOf(ISSUE))).should(Condition.exist);
    }
}
