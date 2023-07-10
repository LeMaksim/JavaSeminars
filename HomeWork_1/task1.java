package HomeWork_1;
/**
 * 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n!
 * (произведение чисел от 1 до n)
 */
public class task1 {

    public static void main(String[] args) {
        // Реализация мметода вычисления треугольного числа
        System.out.println(summary(5));
        // Реализация метода вычисления факториала n.
        System.out.println(factorial(5));

    }

    // Метод вычисления треугольного n-числа
    static int summary(int number) {
        int result = 0;
        for (int i = 1; i < number + 1; i++) {
            result = result + i;
        }
        return result;
    }

    // Метод вычисления n!(n-факториала)
    static int factorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}