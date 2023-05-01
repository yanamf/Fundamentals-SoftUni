package MidExamPrep;

import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sumWithTax = 0;
        double sumNoTax = 0;
        double taxes = 0;

        while (!(input.equals("special") || input.equals("regular"))) {
            double currentNumber = Double.parseDouble(input);
            if (currentNumber < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            taxes = taxes + currentNumber * 0.20;
            sumNoTax += currentNumber;
            sumWithTax = sumWithTax + currentNumber * 1.20;

            input = scanner.nextLine();
        }
        if (sumNoTax == 0) {
            System.out.println("Invalid order!");
            return;
        }
        if (input.equals("special")) {
            sumWithTax *= 0.90;
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$", sumNoTax, taxes, sumWithTax);
        }
        if (input.equals("regular")) {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$", sumNoTax, taxes, sumWithTax);

        }

    }
}
