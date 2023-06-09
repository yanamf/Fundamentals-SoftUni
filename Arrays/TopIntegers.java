package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < number.length; i++) {
            int currentNum = number[i];
            for (int j = i + 1; j < number.length; j++) {

                if (max < number[j]) {
                    max = number[j];
                }
            }
            if (i == number.length - 1){
                System.out.print(currentNum);
            } else if (currentNum>max) {
                System.out.print(currentNum + " ");
            }
            max = 0;
        }
    }
}
