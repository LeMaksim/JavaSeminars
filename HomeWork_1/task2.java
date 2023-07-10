package HomeWork_1;
/*
 * 2) Вывести все простые числа от 1 до 1000
 */

public class task2 {
    public static void main(String[] args) {
        // Вывод всех простых чисел в заданном диапазоне осуществляется проверкой
        // условия "простоты",
        // а именно: число имеет строго 2 натуральных делителя, с последующим выводом
        // результата.
        int finalnumber = 1000;
        for (int i = 2; i < finalnumber; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrimeNumber(int number) {
        int i = 2;
        do {
            if (number == 2) {
                return true;
            }
            if ((number % i) != 0) {
                i++;
            } else
                return false;
        } while (i < number);
        if (i < number) {
            return false;
        } else {
            return true;
        }
    }
}
