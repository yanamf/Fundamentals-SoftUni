package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int indexOne = 0;
        int indexTwo = 0;
        while (!command.equals("end")){
            for (int i = 0; i < numberArr.length; i++) {
                indexOne = numberArr[1];
                indexTwo = numberArr[2];
            }
        }

    }
}
