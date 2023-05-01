package TextProcess;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);

        int totalStrength = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == '>'){
                int attack = Integer.parseInt(text.charAt(i + 1) + "");
                totalStrength += attack;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                text.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }
        System.out.println(text);
    }
}
