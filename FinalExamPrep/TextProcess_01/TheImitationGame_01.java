package FinalExamPrep.TextProcess_01;

import java.util.*;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();

        StringBuilder currentText = new StringBuilder(message); //zzHe
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int count = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < count; i++) {
                        char letterToMove = currentText.charAt(0);
                        currentText.deleteCharAt(0);
                        currentText.append(letterToMove);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    if (index>= 0 && index <= currentText.length()){
                        currentText.insert(index, value);
                    }
                    break;
                case "ChangeAll": //ChangeAll|z|l
                    String oldLetter = tokens[1]; //z
                    String newLetter = tokens[2]; //l
                    while (currentText.substring(0, currentText.length()).contains(oldLetter)){
                        currentText.replace(currentText.indexOf(oldLetter), currentText.indexOf(oldLetter), newLetter);
                        currentText.deleteCharAt(currentText.indexOf(oldLetter));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", currentText);
    }
}
