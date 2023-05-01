package AssociativeArrays;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<Double>> collection = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] sequence = input.split(" ");
            String product = sequence[0];
            double price = Double.parseDouble(sequence[1]);
            double quantity = Double.parseDouble(sequence[2]);

            if (!collection.containsKey(product)) {
                collection.put(product, new ArrayList<>());
                collection.get(product).add(0, price);
                collection.get(product).add(1, quantity);

            } else {
                collection.get(product).set(1, collection.get(product).get(1) + quantity);
                collection.get(product).set(0, price);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : collection.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().get(0)
            *entry.getValue().get(1));
        }
    }
}
