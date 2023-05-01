package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;

        for (int i = 0; i < numsArr.length - 1; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                leftSum += numsArr[leftIndex];
            }
            for (int rightIndex = numsArr.length - 1; rightIndex > i; rightIndex--) {
                rightSum += numsArr[rightIndex];

            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isEqual = true;
                break;
            }
        }
        if (!isEqual) {
            System.out.println("no");
        }

    }
}