package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    void gitHubIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $("[name=q]").click();
        $("[name=q]").setValue("ElenaElena555").pressEnter();
        $$(".menu-item").find(Condition.text("Users")).click();
        $(By.linkText("ElenaElena555")).click();
        $("[data-tab-item=repositories]").click();
         $("#user-repositories-list").$(byText("demoqa-tests-12")).click();
        $(By.partialLinkText("Issues")).shouldBe(visible);
    }
}
