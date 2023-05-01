package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];
        int[] value = new int[n];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();

            int vowels = 0;
            int consonant = 0;
            char[] charArr = names[i].toCharArray();
            for (char index : charArr) {
                if (index == 'A' || index == 'a' || index == 'E'
                        || index == 'e' || index == 'O' || index == 'o'
                        || index == 'U' || index == 'u' || index == 'I'
                        || index == 'i') {
                    vowels += ((int) index * names[i].length());
                } else {
                    consonant += ((int) index / names[i].length());
                }
            }
            int sum = vowels + consonant;
            value[i] = sum;
        }
        Arrays.sort(value);
        for (int values: value){
            System.out.println(values);
        }

    }
}
