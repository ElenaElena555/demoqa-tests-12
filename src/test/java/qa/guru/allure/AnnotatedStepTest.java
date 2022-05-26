package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    private static final String Repository = "ElenaElena555";

    @Test
    void gitHubIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
      WebSteps steps = new WebSteps();

      steps.openMainPage();
      steps.searchUser(Repository);
      steps.openRepository();
      steps.clickOnRepository();
      steps.shouldSeeIssieTab();
    }
}
