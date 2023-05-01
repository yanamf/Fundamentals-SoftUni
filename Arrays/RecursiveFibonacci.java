package Arrays;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = new int[Integer.parseInt(scanner.nextLine())];

        if(inputArr.length<=1){
            System.out.println("1");
        } else {
            inputArr[0] = 1;
            inputArr[1] = 1;
            for (int i = 2; i < inputArr.length; i++) {
                inputArr[i] = inputArr[i-1] + inputArr[i-2];
            }
        }
        boolean fibonacci = false;
        int count = 0;

    }
}
