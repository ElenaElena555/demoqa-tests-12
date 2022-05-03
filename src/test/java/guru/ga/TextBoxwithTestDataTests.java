package guru.ga;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.utils.RandomUtils.getRandomEmail;
import static guru.utils.RandomUtils.getRandomString;

public class TextBoxwithTestDataTests {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = getRandomString(10);
        String surname = getRandomString(10);
        String email = getRandomEmail();
        String number = "9214232563";
        String month = "November";
        String year = "1992";
        String subjectInput = "Computer Science";
        String currentAddress = "Montenegro";
        String state = "NCR";
        String city = "Noida";


        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byText("24")).click();
        $(byText("Sports")).click();
        $(byText("Female")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#subjectsInput").setValue(subjectInput).pressEnter();
        $("#currentAddress").setValue(currentAddress);
        Selenide.zoom(0.75);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        // Проверка
        $(".table-responsive").shouldHave(
                text(name + " " + surname),
                text(email),
                text(number),
                text(month),
                text(year),
                text("24"),
                text("Sports"),
                text("Female"),
                text("1.jpg"),
                text(subjectInput),
                text(currentAddress),
                text("NCR"),
                text("Noida")
        );
    }

}
