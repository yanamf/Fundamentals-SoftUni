package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number.length - 1; i++) {
            int currentNum = number[i];

            for (int j = i + 1; j < number.length; j++) {
                int secondNum = number[j];
                if (currentNum + secondNum == n) {
                    System.out.printf("%d %d %n", currentNum, secondNum);
                }
            }
        }


    }
}
