package FinalExamPrep.Map_03;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> rarity = new LinkedHashMap<>();
        Map<String, List<Double>> rating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input =
                    scanner.nextLine().split("<->"); //[plant] [rarity]
            String plant = input[0];
            Integer currentRarity = Integer.parseInt(input[1]);

            rarity.put(plant, currentRarity);
            rating.putIfAbsent(plant, new ArrayList<>());
        }
        String input;
        while (!"Exhibition".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String plantName = tokens[1];
            if (!rarity.containsKey(plantName)) {
                System.out.println("error");
                continue;
            }
            if (input.startsWith("Rate")) {
                // [Rate:] [Plant] [-] [Rating]
                rating.putIfAbsent(plantName, new ArrayList<>());
                rating.get(plantName).add(Double.parseDouble(tokens[3]));
            } else if (input.startsWith("Update")) {
                // [Update:] [Plant] [-] [new_rarity]
                rarity.put(plantName, Integer.parseInt(tokens[3]));
            } else if (input.startsWith("Reset")) {
                // Reset: {plant}
                // (reset ratings)
                rating.get(plantName).clear();
            }
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : rarity.entrySet()) {

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey()
                    , entry.getValue(),rating.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
        }
    }
}
