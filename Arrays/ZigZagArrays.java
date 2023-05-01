package Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] twoInt = new int[n];


        for (int i = 0; i < n; i++) {
            twoInt[i] = Integer.parseInt(scanner.nextLine());


        }
    }
}
