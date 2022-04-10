package guru.ga;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {
    @BeforeAll
    static void initDB(){
        System.out.println("### @BeforeAll");
    }
    @BeforeEach

    void openYaPage(){  Selenide.open("https://yandex.ru");
        System.out.println("### @BeforeEach");

    }
    @AfterEach

    void closeYaPage(){
        System.out.println("### @AfterEach");
        WebDriverRunner.closeWindow();
          }
    @AfterAll
    static void cleanDB(){
        System.out.println("### @AfterAll");
    }

    @Test
    void assertTest(){
        System.out.println("### @Test 0");
 //...
    }

    @Test
    void assertTest2(){
        System.out.println("### @Test 1");
    //...
    }
}
