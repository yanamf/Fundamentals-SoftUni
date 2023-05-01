package FinalExamPrep.Map_03;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Integer>> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            //{car}|{mileage}|{fuel}
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            cars.put(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
        }
        String input;
        while (!"Stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" : ");
            String car = tokens[1];
            if (input.contains("Drive")) {

                int distance = Integer.parseInt(tokens[2]);
                int fuel = Integer.parseInt(tokens[3]);
                if ((fuel > cars.get(car).get(1))) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    int newMileage = cars.get(car).get(0) + distance;
                    int newFuel = cars.get(car).get(1) - fuel;

                    cars.get(car).set(0, newMileage);
                    cars.get(car).set(1, newFuel);
                    System.out.printf
                            ("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                    , tokens[1], distance, fuel);
                    if (cars.get(car).get(0) >= 100000) {
                        cars.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                }

            } else if (input.contains("Refuel")) {
                int fuel = Integer.parseInt(tokens[2]);
                int difference = 75 - cars.get(car).get(1);
                if (fuel + cars.get(car).get(1) >= 75) {
                    fuel = 75;
                    cars.get(car).set(1, fuel);
                    System.out.printf("%s refueled with %d liters%n", tokens[1], difference);
                } else {
                    int newFuelToAdd = cars.get(car).get(1) + fuel;
                    cars.get(car).set(1, newFuelToAdd);
                    System.out.printf("%s refueled with %d liters%n", tokens[1], fuel);
                }
            } else if (input.contains("Revert")) {
                int km = Integer.parseInt(tokens[2]);
                int newMileage = cars.get(car).get(0) - km;
                if (newMileage < 10000) {
                    cars.get(car).set(0, 10000);
                } else {
                    cars.get(car).set(0, newMileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n", tokens[1]
                            , km);
                }
            }
        }
        for (Map.Entry<String, List<Integer>> entry : cars.entrySet()) {
            System.out.printf
                    ("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey()
                            , entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
