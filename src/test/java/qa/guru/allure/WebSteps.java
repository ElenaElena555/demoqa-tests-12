package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем пользователя")
    public void searchUser(String repo) {
        $("[name=q]").click();
        $("[name=q]").setValue(repo).pressEnter();
        $$(".menu-item").find(Condition.text("Users")).click();
        $(By.linkText(repo)).click();
    }

    @Step("Открываем репозиторий")
    public void openRepository() {
        $("[data-tab-item=repositories]").click();
    }

    @Step("Переходим по ссылке репозитория")
    public void clickOnRepository() {
        $("#user-repositories-list").$(byText("demoqa-tests-12")).click();
    }

    @Step("Проверяем наличие таба Issues")
    public void shouldSeeIssieTab() {
        $(By.partialLinkText("Issues")).shouldBe(visible);
        attachScreenshot();
    }
    @Attachment(value = "Мой любтимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot(){
        return((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
