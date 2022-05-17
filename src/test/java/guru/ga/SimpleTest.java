package guru.ga;

import guru.pages.components.ComponentsForParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SimpleTest {
    ComponentsForParameterizedTest componentsForParameterizedTest = new ComponentsForParameterizedTest();

    //  @BeforeAll
    //  void setUp() {
    //      componentsForParameterizedTest.hideAds();
    //   }

    @ValueSource(strings = {"1984", "Paper"})
    @DisplayName("Verification of the searching for books and presents")
    @ParameterizedTest(name = "Verification of the searching for {0}")
    void bookvoedSearchTest(String testData) {
        //Preconditions:
        componentsForParameterizedTest.openPageBook();

        //      Steps to reproduce:
        componentsForParameterizedTest.findNameToSearchField(testData);

        //     Expected result:
        //      Page opens with the "Оруэлл 1984" page
        componentsForParameterizedTest.checkResult(testData);

    }

    @CsvSource({"1984, 1984", "Paper, Paper"})
    @ParameterizedTest(name = "Verification of the searching for {0}, expected result {1}")
    void bookvoedSearchComplexTest(String testData, String expectedResult) {
        //Preconditions:
        componentsForParameterizedTest.openPageBook();

        //      Steps to reproduce:
        componentsForParameterizedTest.findNameToSearchField(testData);

        //     Expected result:
        //      Page opens with the "Оруэлл 1984" page
        componentsForParameterizedTest.checkResult(expectedResult);

    }

    @CsvSource({"Budva, Budva", "Pogorica, Pogorica"})
    @ParameterizedTest(name = "Verification of the searching booking from {0}")
    void findTicketsToMontenegro(String testData1, String expectedResult1) {
        //Preconditions:
        //    1. Go to https:/https://www.booking.com/
        componentsForParameterizedTest.openPageForBooked();

        //   Steps to reproduce:
        componentsForParameterizedTest.selectCity(testData1);
        componentsForParameterizedTest.selectDates();
        componentsForParameterizedTest.comfirmChoice();

        //    Expected result:
       componentsForParameterizedTest.checkResultOfSeraching(expectedResult1);

    }
}
