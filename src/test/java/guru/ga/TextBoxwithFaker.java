package guru.ga;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.pages.RegistartionFromPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TextBoxwithFaker {
    RegistartionFromPage registartionFromPage = new RegistartionFromPage();

    Faker faker = new Faker();

    String name = faker.name().firstName();
    String surname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.harryPotter().quote();
    String year = "1992";
    String day = "24";
    String subjectInput = "Computer Science";
    String state = "NCR";
    String city = "Noida";
    String number = "9214232563";
    String month = "November";
    String hobby = "Sports";
    String gender = "Female";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        //Заполнение формы регистрации

        registartionFromPage
                .openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setState(state)
                .setCity(city)
                .setCurrentAddress(currentAddress)
                .setSubjectInput(subjectInput)
                .setHobby(hobby)
                .uploadPicture("1.jpg")
                .setDateOfBithday(day, month, year)
                .setSubmit();


        // Проверка формы регистрации

        registartionFromPage
                .checkForm("Student Name", name +" "+surname)
                .checkForm("Student Email", email)
                .checkForm("Mobile", number)
                .checkForm("Date of Birth", day+" "+month+","+year)
                .checkForm("Hobbies", hobby)
                .checkForm("Gender", gender)
                .checkForm("Picture", "1.jpg")
                .checkForm("Subjects", subjectInput)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state)
                .checkForm("State and City",city);

    }

}
