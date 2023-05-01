package TextProcess;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banned = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

            for (String word : banned) {
                String result = "";
                for (int i = 0; i < word.length(); i++) {
                    result += "*";
                }
                text = text.replace(word, result);
            }
        System.out.println(text);
        }
    }

