package guru.pages;

import com.codeborne.selenide.Selenide;
import guru.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistartionFromPage {
    CalendarComponent calendar = new CalendarComponent();

    //locators
    String formHeaderText = "Student Registration Form";

    //actions
    public RegistartionFromPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Selenide.zoom(0.75);
        $(".practice-form-wrapper").shouldHave(text(formHeaderText));
        return this;
    }

    public RegistartionFromPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public RegistartionFromPage setLastName(String surname) {
        $("#lastName").setValue(surname);
        return this;
    }

    public RegistartionFromPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistartionFromPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistartionFromPage setUserNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistartionFromPage setState(String state) {
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistartionFromPage setCity(String city) {
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistartionFromPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistartionFromPage setSubjectInput(String subjectInput) {
        $("#subjectsInput").setValue(subjectInput).pressEnter();
        return this;
    }

    public RegistartionFromPage setHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistartionFromPage uploadPicture(String value1) {
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        return this;
    }

    public RegistartionFromPage setDateOfBithday(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setCalendarDate(day, month, year);
        return this;
    }

    public RegistartionFromPage setSubmit() {
        $("#submit").click();

        return this;
    }

    public RegistartionFromPage checkForm(String fieldName, String value) {
        $(".table-responsive").$(byText(fieldName)).parent().shouldHave(text(value));

        return this;
    }
}
