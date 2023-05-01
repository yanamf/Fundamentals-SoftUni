package FinalExam;

import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" \\| ");
        //{word1}: {description} | {word2}: {description} | … {wordN}: {description}
        LinkedHashMap<String, List<String>> wordsAndDefinitions = new LinkedHashMap<>();

        for (String word : input) {
            // {word1}: {description}
            String[] tokens = word.split(": ");
            String currentWord = tokens[0];
            String currentDefinition = tokens[1];

            if (wordsAndDefinitions.containsKey(currentWord)) {
                wordsAndDefinitions.get(currentWord).add(currentDefinition);
            } else {
                wordsAndDefinitions.put(currentWord, new ArrayList<>());
                wordsAndDefinitions.get(currentWord).add(currentDefinition);
            }
        }
        String[] tests = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();
        if (command.equals("Test")) {
            for (int i = 0; i < tests.length ; i++) {
                if (wordsAndDefinitions.containsKey(tests[i])) {
                    System.out.printf("%s:%n", tests[i]);
                    int size = wordsAndDefinitions.get(tests[i]).size();
                    for (int j = 0; j < size; j++) {
                        System.out.println("-" + wordsAndDefinitions.get(tests[i]).get(j));
                    }
                    }
                }

        } else if (command.equals("Hand Over")) {
            for (Map.Entry<String, List<String>> entry : wordsAndDefinitions.entrySet()) {
                System.out.print(entry.getKey() + " ");
            }

        }
    }

}
