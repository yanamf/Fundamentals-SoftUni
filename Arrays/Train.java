package Arrays;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] peopleArray = new int[n];
        int sum = 0;


        for (int i = 0; i < n; i++) {
            peopleArray[i] = Integer.parseInt(scanner.nextLine());
            System.out.print(peopleArray[i] + " ");
            sum += peopleArray[i];
        }
        System.out.printf("%n%d", sum);


    }
}
