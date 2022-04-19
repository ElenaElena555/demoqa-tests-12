package guru.ga;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
        @BeforeAll
        static void setUp () {
            Configuration.holdBrowserOpen = true;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
        }
    @Test
    void fillFormTest (){
        String Name = "Elena";
        String Surname = "Sukhanova";
        String Email = "lenasyhanova@yandex.ru";
        String Number = "9214232563";
        String month = "November";
        String year = "1992";
        String SubjectInput = "Computer Science";
        String currentAddress= "Montenegro";
        String state = "NCR";
        String city ="Noida";


      open ("/automation-practice-form");
      $("#firstName").setValue(Name);
      $("#lastName").setValue(Surname);
      $("#userEmail").setValue(Email);
      $("#userNumber").setValue(Number);
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption(month);
      $(".react-datepicker__year-select").selectOption(year);
      $(byText("24")).click();
      $(byText("Sports")).click();
      $(byText("Female")).click();
      $("#uploadPicture").uploadFromClasspath("1.jpg");
      $("#subjectsInput").setValue(SubjectInput).pressEnter();
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
                text(Name+" "+Surname),
                text(Email),
                text(Number),
                text(month),
                text(year),
                text("24"),
                text("Sports"),
                text("Female"),
                text("1.jpg"),
                text(SubjectInput),
                text(currentAddress),
                text("NCR"),
                text("Noida")
                );
    }

 }
