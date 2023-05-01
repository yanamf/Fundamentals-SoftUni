package FinalExamPrep.Regex_02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#|])(?<item>[A-Za-z ]+\\s*)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern.matcher(text);

        int totalCalories = 0;
        while(matcher1.find()){
            int calories = Integer.parseInt(matcher1.group("calories"));
            totalCalories += calories;
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", item, date, calories);
        }

    }
}
