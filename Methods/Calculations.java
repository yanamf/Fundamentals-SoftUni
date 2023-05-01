package Methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case "add":
                add(n1, n2);
                break;
            case "multiply":
                multiply(n1, n2);
                break;
            case "subtract":
                subtract(n1, n2);
                break;
            case "divide":
                divide(n1, n2);
                break;

        }
    }
    public static void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public static void multiply(int num1, int num2) {
        System.out.println(num1 * num2);
    }
    public static void subtract(int num1, int num2){
        System.out.println(num1-num2);
    }
    public static void divide(int num1, int num2){
        System.out.println(num1/num2);
    }
}