package FinalExamPrep.TextProcess_01;

import java.util.Scanner;

public class LettersChangeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split("\\s+");
        //  [A12b] [s17G]

        for (int i = 0; i < sequence.length; i++) {
            // [A12b]
            // [A] [1] [2] [b]
            String currentSequence = sequence[i];

            for (int j = 0; j < currentSequence.length(); j++) {

            }
        }


    }
}
