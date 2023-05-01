package FinalExamPrep.Map_03;

import java.util.*;
public class PlantDiscovery_03_Simplified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> rarity = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> rating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            rarity.put(input[0], Integer.parseInt(input[1]));
            rating.putIfAbsent(input[0], new ArrayList<>());
        }
        String input;
        while (!"Exhibition".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            if (!rarity.containsKey(tokens[1])) {
                System.out.println("error");
                continue;
            }
            if (input.startsWith("Rate")) rating.get(tokens[1]).add(Double.parseDouble(tokens[3]));
            else if (input.startsWith("Update")) rarity.put(tokens[1], Integer.parseInt(tokens[3]));
            else if (input.startsWith("Reset")) rating.get(tokens[1]).clear();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : rarity.entrySet())
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), rating.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
    }
}