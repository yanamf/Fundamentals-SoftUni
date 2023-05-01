package FinalExamPrep.Map_03;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            //[Moonlight Sonata] [Beethoven] [C# Minor]
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pieces.putIfAbsent(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens2 = input.split("\\|");
            String command = tokens2[0];
            switch (command) {
                case "Add":
                    String pieceToAdd = tokens2[1];
                    if (pieces.containsKey(pieceToAdd)) {
                        System.out.printf("%s is already in the collection!%n", pieceToAdd);
                    } else {
                        String composerToAdd = tokens2[2];
                        String keyToAdd = tokens2[3];

                        pieces.put(pieceToAdd, new ArrayList<>());
                        pieces.get(pieceToAdd).add(composerToAdd);
                        pieces.get(pieceToAdd).add(keyToAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n",
                                pieceToAdd, composerToAdd, keyToAdd);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = tokens2[1];
                    if (pieces.containsKey(pieceToRemove)) {
                        pieces.remove(pieceToRemove);
                        System.out.printf("Successfully removed %s!%n", pieceToRemove);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                    }
                    break;
                case "ChangeKey": //ChangeKey|{piece}|{new key}
                    String oldKey = tokens2[1];
                    String newKey = tokens2[2];

                    if (pieces.containsKey(oldKey)) {
                        pieces.get(oldKey).remove(pieces.get(oldKey).size() - 1);
                        pieces.get(oldKey).add(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", oldKey, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", oldKey);
                    }
                    break;
                default:
                  break;
            }

            input = scanner.nextLine();
        }

        for(Map.Entry<String, List<String>> entry: pieces.entrySet()){
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }


    }
}
