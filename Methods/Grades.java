package Methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());

        grade(n);


    }
    public static void grade (double number){
        if (number>= 2.00 && number<= 2.99){
            System.out.println("Fail");
        } else if (number<=3.49) {
            System.out.println("Poor");
        } else if (number<= 4.49) {
            System.out.println("Good");
        } else if (number<=5.49) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }
}
