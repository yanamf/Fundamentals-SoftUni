package FinalExam;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] tokens = command.split("\\s+");

            if (command.contains("Change")) {

//                int numberAscii = Integer.parseInt(tokens[1]);
//                char symbol = (char) numberAscii;
//                String symbol2 = Character.toString(symbol);
                String symbol = tokens[1];
                String replacement = tokens[2];
                text = text.replace(symbol, replacement);
                System.out.println(text);

            } else if (command.contains("Includes")) {
                String substring = tokens[1];
                if (text.contains(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (command.contains("End")) {
                String substring = tokens[1];
                if (text.endsWith(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (command.contains("Uppercase")) {
                text = text.toUpperCase();
                System.out.println(text);
            } else if (command.contains("FindIndex")) {
                String symbol = tokens[1];
                int index = text.indexOf(symbol);
                System.out.println(index);

            } else if (command.contains("Cut")) {
                // Cut [startIndex] [count]
                int startIndex = Integer.parseInt(tokens[1]);
                int count = Integer.parseInt(tokens[2]);

//                StringBuilder newText = new StringBuilder();
//                String substring = text.substring(startIndex, count + 1);

//                for (int i = startIndex; i <= count; i++) {
//                    newText.append(text.charAt(i));
//                }
                System.out.println(text.substring(startIndex, startIndex + count));
//                System.out.println(substring);

            }


            command = scanner.nextLine();
        }
    }
}
