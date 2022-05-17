package guru.pages.components;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ComponentsForParameterizedTest {

    public ComponentsForParameterizedTest hideAds() {
        $(".zx").click();
        return this;
    }

    public ComponentsForParameterizedTest openPageBook() {
        open("https://www.bookvoed.ru/");
        $(".zx").click();
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        return this;
    }

    public ComponentsForParameterizedTest findNameToSearchField(String testData) {
        $(".su").click();
        $(".hu").setValue(testData).click();
        $(".gu").click();
        return this;
    }

    public ComponentsForParameterizedTest checkResult(String testData) {
        //  $$(".QD").find(Condition.text(testData)).shouldBe(visible);
        $$("#books").find(Condition.text(testData)).shouldBe(visible);
        return this;
    }

    public ComponentsForParameterizedTest openPageForBooked() {
        open("https://www.booking.com/");
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Selenide.zoom(0.75);
        return this;
    }

    public ComponentsForParameterizedTest selectCity(String testData1) {
        $("#ss").click();
        $("#ss").setValue(testData1);
        return this;
    }

    public ComponentsForParameterizedTest selectDates() {
        $(".xp__dates-inner").click();
        $(".bui-calendar").$(byText("17")).click();
        $(".bui-calendar").$(byText("27")).click();
        return this;
    }
    public ComponentsForParameterizedTest comfirmChoice(){
        $(".sb-searchbox__button").click();
        return  this;
    }
    public ComponentsForParameterizedTest checkResultOfSeraching (String expectedResult1){
        $(".efdb2b543b").shouldHave(text(expectedResult1));
        return this;
    }
}
