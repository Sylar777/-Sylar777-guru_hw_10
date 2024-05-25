import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.RepositorySteps;

public class StepsWithAnnotationsTest extends BaseTest{
    RepositorySteps steps;

    public StepsWithAnnotationsTest() {
        this.steps = new RepositorySteps();
    }

    @Test
    void testAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.clickRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueExist(ISSUE);
    }
}
