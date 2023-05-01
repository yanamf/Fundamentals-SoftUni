package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> count = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            if (count.containsKey(symbol)) {
                count.put(symbol, count.get(symbol) + 1);
            } else {
                count.put(symbol, 1);
            }
        }
        count.forEach((Character, Integer) -> System.out.println(Character + " -> "
                + Integer));
    }
}
