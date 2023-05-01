package TextProcess;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] codes = scanner.nextLine().split("\\s+");
        //A12b s17G

        double sum = 0;
        for (String code : codes) {

        }
    }
    private static double getModifiedNumber (String code){
        char letterBefore = code.charAt(0);
        char letterAfter = code.charAt(code.length() - 1);

        double number = Double.parseDouble(code.replace(letterBefore, ' ')
                .replace(letterAfter, ' ')
                .trim());
return number;
        
    }
}
