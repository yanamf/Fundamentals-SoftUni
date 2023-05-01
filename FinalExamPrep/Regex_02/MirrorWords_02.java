package FinalExamPrep.Regex_02;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@#])(?<word1>[A-Za-z]{3,})\\1{2}(?<word2>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Matcher matcher2 = pattern.matcher(text);

        List<String> validWord = new ArrayList<>();

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        while (matcher2.find()) {
            String word1 = matcher2.group("word1");
            String word2 = matcher2.group("word2");
            String word2Reversed = new StringBuilder(matcher2.group("word2")).reverse().toString();
            if (Objects.equals(word1, word2Reversed)) {
                String merged = word1 +" <=> " + word2;
                validWord.add(merged);
            }
        }

        if (count != 0) {
            System.out.printf("%d word pairs found!%n", count);
        } else {
            System.out.println("No word pairs found!");
        }
        if (validWord.size() != 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", validWord));

        } else {
            System.out.println("No mirror words!");
        }

    }
}
