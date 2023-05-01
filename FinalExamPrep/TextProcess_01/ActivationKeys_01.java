package FinalExamPrep.TextProcess_01;

import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder rawActivationKey = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] instructions = input.split(">>>");
            String command = instructions[0];

            if (command.equals("Contains")) {
                //Contains>>>{substring}
                String substring = instructions[1];
                if (rawActivationKey.toString().contains(substring)) {
                    System.out.printf
                            ("%s contains %s%n", rawActivationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (command.equals("Flip")) {
                //Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}
                String upOrLo = instructions[1];
                int startIndex = Integer.parseInt(instructions[2]);
                int endIndex = Integer.parseInt(instructions[3]);
                if (upOrLo.equals("Upper")) {
                    String substring = rawActivationKey.substring(startIndex, endIndex).toUpperCase();
                    rawActivationKey.replace(startIndex, endIndex, substring);
                } else if (upOrLo.equals("Lower")) {
                    String substring = rawActivationKey.substring(startIndex, endIndex).toLowerCase();
                    rawActivationKey.replace(startIndex, endIndex, substring);
                }
                System.out.println(rawActivationKey);
            } else if (command.equals("Slice")) {
                //Slice>>>{startIndex}>>>{endIndex}
                int startIndex = Integer.parseInt(instructions[1]);
                int endIndex = Integer.parseInt(instructions[2]);
                rawActivationKey.replace(startIndex, endIndex, "");
                System.out.println(rawActivationKey);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", rawActivationKey);
    }
}
