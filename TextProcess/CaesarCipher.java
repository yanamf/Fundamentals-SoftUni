package TextProcess;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder newText = new StringBuilder();


        for (char symbol : input.toCharArray()) {
            char encryptSymbol = (char) (symbol + 3);
            newText.append(encryptSymbol);
        }
        System.out.println(input);
    }
}
