package AssociativeArrays;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();


        for (String word : sequence) {
            word = word.toLowerCase();

            counts.putIfAbsent(word, 0);
            counts.put(word, counts.get(word) + 1);

//            if (!counts.containsKey(lowercase)) {
//                counts.put(lowercase, 1);
//            } else {
//                counts.put(lowercase, counts.get(lowercase) + 1);
//            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()){
            if (entry.getValue() % 2 !=0) {
                result.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", result));
    }
}
