package guru.ga;

import static guru.utils.RandomUtils.*;

public class TextBoxwithRandomUtilsExamplesTests {
    public static void main(String[] args) {
        System.out.println("RandomUtilsExamples " + getRandomString(10));
        System.out.println("RandomUtilsExamples " + getRandomInt(2,4));
        System.out.println("RandomUtilsExamples " + getRandomEmail());
    }

}
