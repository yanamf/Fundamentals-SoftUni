package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int numberOfMoves = 0;

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            //Взимаме си индексите от инпут-а
            int firstIndex = Integer.parseInt(tokens[0]);
            int secondIndex = Integer.parseInt(tokens[1]);

            numberOfMoves++;
            // Проверяваме дали индексите са валидни
            if (firstIndex >= 0 && firstIndex < numbers.size() &&
                    secondIndex >= 0 && secondIndex < numbers.size() && !(firstIndex == secondIndex)) {
                if (numbers.get(firstIndex).equals(numbers.get(secondIndex))) {
                    String element = numbers.get(firstIndex);
                    if(firstIndex>secondIndex){
                        numbers.remove(firstIndex);
                        numbers.remove(secondIndex );
                    } else{
                        numbers.remove(secondIndex );
                        numbers.remove(firstIndex);
                    }
                    System.out.printf("Congrats! You have found matching elements - %s!%n", element);
                    // Проверяваме дали листът е празен
                    if (numbers.isEmpty()) {
                        System.out.printf("You have won in %d turns!%n", numberOfMoves);
                        break;
                    }
                } else {
                    System.out.println("Try again!");
                }
            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                int middleOfSequence = numbers.size() / 2 ;
                int middleOfSequence2 = middleOfSequence + 1;
                numbers.add(middleOfSequence, "-" + numberOfMoves + "a");
                numbers.add(middleOfSequence2, "-" + numberOfMoves + "a");

            }
            input = scanner.nextLine();
        }

        if (!numbers.isEmpty()) {
            System.out.println("Sorry you lose :(");
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}

