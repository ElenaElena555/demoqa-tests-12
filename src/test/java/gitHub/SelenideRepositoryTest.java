package gitHub;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {
    @Test
 void shouldFindJunit5FromGithub(){

        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$(byText("selenide")).click();
        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // убедится, что в списке страниц (Pages) есть страница SoftAssertions
        //  $(".markdown-body").find(byText("SoftAssertions")).click();  не смогла вызвать элемент из списка этим способом, пробовала
        //  "ul li" но не находит
        $(byText("Soft assertions")).click();
        // открыть страницу SoftAssertions,
        // проверить, что внутри есть пример кода для JUnit5
        $$("ol").shouldHave(texts("JUnit5 extension"));
    }



}

