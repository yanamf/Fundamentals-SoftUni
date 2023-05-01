package FinalExamPrep.Regex_02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([:*])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matcherDigits = patternDigits.matcher(input);

        LinkedHashMap<String, Integer> emojis = new LinkedHashMap<>();
        int sum = 1;
        while (matcherDigits.find()) {
            sum *= Integer.parseInt(matcherDigits.group());
        }
        while (matcher.find()) {
            int sumAscii = 0;
            String emoji = matcher.group("emoji");
            String unCutEmoji = matcher.group();
            for (int i = 0; i < emoji.length(); i++) {
                sumAscii += emoji.charAt(i);
            }
            emojis.put(unCutEmoji, sumAscii);
        }
        int emojiCount = emojis.size();
        System.out.printf("Cool threshold: %d%n", sum);
        System.out.printf
                ("%d emojis found in the text. The cool ones are: %n",
                        emojiCount);

        for (Map.Entry<String, Integer> entry : emojis.entrySet()) {
            int coolness = entry.getValue();
            if (coolness > sum) {
                System.out.println(entry.getKey());
            }
        }

    }

}
