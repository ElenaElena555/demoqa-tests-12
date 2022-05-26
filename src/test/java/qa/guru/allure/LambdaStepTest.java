package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    private static final String Repository = "ElenaElena555";

    @Test
    void gitHubIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем пользователя " + Repository, () -> {
            $("[name=q]").click();
            $("[name=q]").setValue(Repository).pressEnter();
            $$(".menu-item").find(Condition.text("Users")).click();
            $(By.linkText(Repository)).click();


        });
        step("Открываем репозиторий", () -> {
            $("[data-tab-item=repositories]").click();
        });
        step("Переходим по ссылке репозитория", () -> {
            $("#user-repositories-list").$(byText("demoqa-tests-12")).click();
        });
        step("Проверяем наличие таба Issues ", () -> {
            $(By.partialLinkText("Issues")).shouldBe(visible);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });

    }
}
