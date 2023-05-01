package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "\\!(?<command>[A-Z][a-z]{2,})\\!\\:\\[(?<textString>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                List<Integer> numbers = new ArrayList<>();
                String textString = matcher.group("textString");
                String command = matcher.group("command");
                for (int j = 0; j < textString.length(); j++) {
                    if (textString.charAt(j) != ' ') {
                        char letter = textString.charAt(j);
                        numbers.add((int) letter);
                    }
                }
                System.out.printf("%s: ", command);
                System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }


        }
    }
}
