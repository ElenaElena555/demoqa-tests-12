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
        String Number = "89214232563";
        String month = "November";
        String year = "1992";
        String SubjectInput = "Computer Science";
        String currentAddress= "Montenegro";
        String state = "NCR";
        String city ="Noida";
      //   executeJavaScript("$('footer').remove()");
        //   executeJavaScript("$('#fixedban').remove()");
        //    SelenideElement stateCityWrapper = $("#stateCity-wrapper");

      open ("/automation-practice-form");
      $("[id=firstName]").setValue(Name);
      $("[id=lastName]").setValue(Surname);
      $("[id=userEmail]").setValue(Email);
      $("[id=userNumber]").setValue(Number);
      $("[id=dateOfBirthInput]").click();
      $("[class=react-datepicker__month-select]").selectOption(month);
      $("[class=react-datepicker__year-select]").selectOption(year);
      $(byText("24")).click();
      $(byText("Sports")).click();
      $(byText("Female")).click();
      $("[id=uploadPicture]").uploadFromClasspath("1.jpg");
      $("#subjectsInput").setValue(SubjectInput).pressEnter();
      $("#currentAddress").setValue(currentAddress);
         Selenide.zoom(0.55);
         //  Я попробовала три варианта проверки по городам, но перекрывает реклама, не могу ее убрать
   //    $("#stateCity-wrapper").scrollIntoView(true);
    // $("#stateCity-wrapper").$(byText("NCR")).click();
    // $("#stateCity-wrapper").$(byText("Noida")).click();

     //    $("[class=css-1wa3eu0-placeholder]").selectOption("css-1hwfws3");;
     //    $("#css-1wa3eu0-placeholder]").click();
     //    $(byText("Noida")).click();//   stateCityWrapper.$(byText("Select State")).click();

    //    stateCityWrapper.$(byText(state)).click();
    //    stateCityWrapper.$(byText("Select City")).click();
     //   stateCityWrapper.$(byText(city)).click();
        $("[id=submit]").click();

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
                text(SubjectInput),
                text(currentAddress)
         //       text("NCR"),
         //     text("Noida")
                );
    }

 }
