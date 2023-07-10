package HomeWork_1;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 3) Реализовать простой калькулятор
 */
public class task3 {
    static void display(Object num1, Object num2, char key) {
        System.out.printf("\n%.2f %c %.2f = %.2f", Float.parseFloat(num1.toString()), key,
                Float.parseFloat(num2.toString()), generalAction(num1, num2, key));
    }

    static void manual() {
        System.out.println("Welcome to our *SIMPLE CALCULATOR*.");
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        Object num1 = iScanner.next();
        System.out.print("Enter second one: ");
        Object num2 = iScanner.next();
        System.out.print("Now pass me what to do (+, -, *, /): ");
        char key = iScanner.next().toString().charAt(0);
        System.out.print("\033[H\033[J");
        System.out.print("*".repeat(38));
        iScanner.close();
        display(num1, num2, key);
    }

    static List<Object> separationForAuto(String string) {
        char operator = 0;
        String str1 = "";
        String str2 = "";
        int index = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if ((Character.isDigit(string.charAt(i))) | (string.charAt(i) == '.')) {
                str1 = str1 + string.charAt(i);
            } else {
                index = i;
                operator = string.charAt(i);
                str2 = string.substring(i + 1);
                break;
            }
        }
        return Arrays.asList(str1, str2, operator);
    }

    static Object generalAction(Object num1, Object num2, char key) {

        num1 = Float.parseFloat(num1.toString());
        num2 = Float.parseFloat(num2.toString());

        Map<Character, Integer> action = new HashMap<>();
        action.put('+', 1);
        action.put('-', 2);
        action.put('*', 3);
        action.put('/', 4);
        switch (action.get(Character.valueOf(key))) {
            // сложение
            case 1:
                return (Object) ((float) num1 + (float) num2);

            // вычитание
            case 2:
                return (Object) ((float) num1 - (float) num2);

            // умножение
            case 3:
                return (Object) ((float) num1 * (float) num2);

            // деление
            case 4:
                return (Object) ((float) num1 / (float) num2);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        manual();
    }
}
