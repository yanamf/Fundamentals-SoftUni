package FinalExamPrep.Map_03;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String[] tokens = command.split("\\|\\|");
            //Tortuga||345000||1250
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(population);
                cities.get(city).add(gold);
            } else {
                int currentPopulation = cities.get(city).get(0);
                int currentGold = cities.get(city).get(1);

                cities.get(city).set(0, currentPopulation + population);
                cities.get(city).set(1, currentGold + gold);
            }
            command = scanner.nextLine();
        }
        String text = scanner.nextLine();
        while (!text.equals("End")) {
            String[] tokens = text.split("=>");
            String action = tokens[0];
            String city = tokens[1];

            if (action.equals("Plunder")) {
                // [Plunder][town][people][gold]
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);

                cities.get(city).set(0, cities.get(city).get(0) - people);
                cities.get(city).set(1, cities.get(city).get(1) - gold);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                if (cities.get(city).get(0) == 0 || cities.get(city).get(1) == 0) {
                    cities.remove(city);
                    System.out.printf("%s has been wiped off the map!%n", city);

                }
            } else if (action.equals("Prosper")) {
                int goldProsper = Integer.parseInt(tokens[2]);
                if (goldProsper < 0){
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(city).set(1, cities.get(city).get(1) + goldProsper);
                    System.out.printf
                            ("%s gold added to the city treasury. %s now has %d gold.%n", goldProsper, city, cities.get(city).get(1));
                }
            }
            text = scanner.nextLine();
        }
        if (cities.size() > 0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            for (Map.Entry<String, List<Integer>> entry : cities.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
