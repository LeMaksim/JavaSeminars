package Homework_2;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class task2 {
    public static void bubleSorting(int[] array) throws Exception {
        // This empty array needs to refill final file
        int[] exterminator = {};
        writeToFile(exterminator, 0, false);
        // This "guy" help us to implement endless cycle
        boolean isSorted = false;
        int temp;
        int count = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            count++;
            writeToFile(array, count, true);
        }
    }

    // Read string from file, convert it via mapping to array and return integer
    // array;
    static int[] readFromFile(String path) throws Exception {
        FileReader fReader = new FileReader(path);
        Scanner scan = new Scanner(fReader);
        int[] unsortedArray = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        fReader.close();
        return unsortedArray;
    }

    // This method work with input array and write to destination file string of
    // each stage of bubble sorting.
    static void writeToFile(int[] array, int count, boolean token) throws Exception {
        FileWriter fWriter = new FileWriter("Homework_2/log.txt", token);
        String[] string = Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        if (count != 0) {
            stringBuilder.append(count + ": ").append(String.join(", ", string) + "\n");
        }
        fWriter.write(stringBuilder.toString());
        fWriter.close();
    }

    // Our Main program first clean the console
    // then fix problem with "packaging" that created file in root repo directory,
    // not in required directory.
    // Next it initialize an integer array and implement the key method
    // bubleSorting().
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[J");
        String path = "Homework_2/unsorted.txt";
        int[] unsorted = readFromFile(path);
        bubleSorting(unsorted);

    }

}
