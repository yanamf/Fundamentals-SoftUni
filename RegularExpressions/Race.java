package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racersNames =
                Arrays.stream(scanner.nextLine()
                                .split(", "))
                        .collect(Collectors.toList());

        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racersNames.forEach(racer -> racersDistances.put(racer, 0));

        String regexLetter = "[A-Za-z]";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            StringBuilder sb = new StringBuilder();
            Matcher matcherLetter = patternLetter.matcher(input);

            //name
            while (matcherLetter.find()) {
                sb.append(matcherLetter.group());

            }
            //distance
            int distance = 0;
            Matcher matcherDigits = patternDigits.matcher(input);

            while (matcherDigits.find()) {
                distance += Integer.parseInt(matcherDigits.group());
            }
            //Do we have this racer
            String racerName = sb.toString();
            if (racersNames.contains(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }


            input = scanner.nextLine();
        }
        for (int index = 0; index <= 2; index++) {
            String racer = racersNames.get(index);
            if (index == 0) {
                System.out.println("1st place: " + racer);
            } else if (index == 1) {
                System.out.println("2nd place: " + racer);
            } else if (index == 2) {
                System.out.println("3rd place: " + racer);
            }
        }

    }
}
