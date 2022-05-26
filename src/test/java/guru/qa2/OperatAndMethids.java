package guru.qa2;

public class OperatAndMethids {
    public static void main(String []args) {
        byte exByte = 8; // -128 to 128
        short exShort = 16; // -32768 to 32767
        int exInt = 32;     // -2147483648 to 2147483647
        long exLong = 64;  // -9223372036854775808 to 9223372036854775807
        float exFloat = 2.3f;//  1.4e-45f to 3.4e+38f
        double exDouble = 2.3; // 4.9e-324 to 1.7e+308
        boolean exBoolean = false;  // true or false
        char exChar = 'a'; // an unsigned integer representing a UTF-16 character (letters and numbers)
        String exString = "Hello"; //
        
        //Написать код, использующий большинство или все виды операторов, о которых сегодня говорилось.
        int num1 = 1;
        int num2 = 56;
        int num3 = -5;
        // арифметические операторы;
        int num4 = num1 + num2;
        int num5 = num2 - num3;
        int num6 = num1 * num2;
        int num7 = num1 / num2;
        int num8 = num1 % num2;
        System.out.println("Сложение" + num4);
        System.out.println("Вычитание" + num5);
        System.out.println("Умножение" + num6);
        System.out.println("Деление" + num7);
        System.out.println("Остаток от деления" + num8);
        System.out.println("Инкремент" + (num1++));
        System.out.println("Декремент" + (--num2));
        //операторы сравнения;
        int a = 5;
        int b = 20;
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        System.out.println("b >= a = " + (b >= a));
        System.out.println("b <= a = " + (b <= a));

        // побитовые операторы;
        int num10 = 1;
        int num20 = 56;
        int num30 = -5;
        num30 = num10 & num20;
        System.out.println(" |  " + num30);

        num30 = num10 ^ num20;
        System.out.println(" ^ " + num30);
        // логические операторы;
        boolean num9 = true;
        boolean num99 = false;

        System.out.println(" && " + (num9 && num99));

        System.out.println("||" + (num9 || num99));

        System.out.println("!( && ) = " + !(num9 && num99));


        //Показать примеры операций над разными типами данных (int + long, например).
        int num67 = -2147;
        float Float = 2.3f;
        System.out.println("сложение разных типов данных"+ (num67+Float));

        //Добиться переполнения в min и max сторону и посмотреть что произойдет.
        int num55 = -2147483648;
        int num66 = -2147483648;
        System.out.println("toomin"+(num55+num66));
        short num556 = 32767;
        short num666 = 32767;
        System.out.println("toomax"+(num666+num556));

    }
}


