package FinalExamPrep.Regex_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMap_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([=/]{1})(?<place>[A-Z][A-Z-a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int sum = 0;
        while (matcher.find()) {
            String currentPlace = matcher.group("place");

            int points = Integer.parseInt(String.valueOf(currentPlace.length()));
            sum += points;
            destinations.add(currentPlace);

        }

        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel Points: %d", sum);
    }
}
