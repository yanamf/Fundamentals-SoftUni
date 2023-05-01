package FinalExamPrep.Regex_02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@#+(?<item>[A-Z][a-zA-Z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);



        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);
            Matcher matcherDigits = patternDigits.matcher(input);

            StringBuilder productGroup = new StringBuilder();

            if (!input.matches(regex)){
                System.out.println("Invalid barcode");
                continue;
            }
            while (matcher.find()){
                while (matcherDigits.find()){
                    productGroup.append(matcherDigits.group());
                }
            }
            if (productGroup.length() == 0){
                System.out.println("Product group: 00");
            } else {
                System.out.println("Product group: " + productGroup);
            }
        }
    }
}
