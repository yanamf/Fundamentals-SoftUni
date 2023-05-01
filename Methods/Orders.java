package Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        double coffee = 1.50;
        double water = 1.00;
        double coke = 1.40;
        double snacks = 2.00;

        switch (type) {
            case "coffee":
                result(coffee, n);
                break;
            case "water":
                result(water, n);
                break;
            case "coke":
                result(coke, n);
                break;
            case "snacks":
                result(snacks, n);
                break;
        }
    }

    public static void result(double type, double price) {
        System.out.printf("%.2f", type * price);
    }
}
