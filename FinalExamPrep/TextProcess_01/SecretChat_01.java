package FinalExamPrep.TextProcess_01;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder sb = new StringBuilder(message);

        while (!command.equals("Reveal")) {
            String[] commands = command.split(":\\|:");

            if (commands[0].equals("InsertSpace")) {
                int index = Integer.parseInt(commands[1]);
                sb.insert(index, ' ');
                System.out.println(sb);
            } else if (commands[0].equals("Reverse")) {
                String substring = commands[1];

                if (sb.toString().contains(substring)) {
                    String reversed = new StringBuilder(substring).reverse().toString();

                    int firstIndex = sb.indexOf(substring);
                    int lastIndex = firstIndex + (substring.length());

                    sb.replace(firstIndex, lastIndex, "");
                    sb.append(reversed);

                    System.out.println(sb);

                } else {
                    System.out.println("error");
                }
            } else if (commands[0].equals("ChangeAll")) {
                String substring = commands[1];
                String newText = commands[2];
                while (sb.toString().contains(commands[1])) {

                    int firstIndex = sb.indexOf(substring);

                    int lastIndex = firstIndex + (substring.length());
                    sb.replace(firstIndex, lastIndex, newText);
                }
                System.out.println(sb);
            }
            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + sb);
    }
}
