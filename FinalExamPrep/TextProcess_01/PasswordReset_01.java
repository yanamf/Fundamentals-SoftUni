package FinalExamPrep.TextProcess_01;

import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder pass = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] tokens = command.split(" ");
            if (command.contains("TakeOdd")) {
                String temporary = takeOdd(pass.toString());
                pass = new StringBuilder(temporary);
                System.out.println(pass);
            } else if (command.contains("Cut")) {
                int index = Integer.parseInt(tokens[1]);
                int substringLength = Integer.parseInt(tokens[2]);
                String textToRemove = pass.substring(index, index + substringLength);
                pass = new StringBuilder(pass.toString().replaceFirst(textToRemove, ""));
                System.out.println(pass);
            } else if (command.contains("Substitute")) {
                String substring = tokens[1];
                String substitute = tokens[2];
                if (pass.toString().contains(substring)) {
                    while (pass.toString().contains(substring)) {
                        int firstIndex = pass.indexOf(substring);
                        int lastIndex = firstIndex + (substring.length());
                        pass.replace(firstIndex, lastIndex, substitute);
                    }
                    System.out.println(pass);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + pass);
    }

    private static String takeOdd(String text) {
        String temporary = "";
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                temporary += text.charAt(i);
            }
        }
        return temporary;
    }
}
