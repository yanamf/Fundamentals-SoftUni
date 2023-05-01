package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine()
                        .split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine()
                        .split(">"))
                .map(Integer::parseInt)

                .collect(Collectors.toList());

        int healthCapacity = Integer.parseInt(scanner.nextLine());

        List<String> commandList = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        while (!"Retire".equals(commandList.get(0))) {
            String command = commandList.get(0);
            switch (command) {
                case "Fire":
                    int indexToFire = Integer.parseInt(commandList.get(1));
                    int damage = Integer.parseInt(commandList.get(2));

                    if (indexToFire >= 0 && indexToFire < warShip.size()) {
                        int newIndex = warShip.get(indexToFire) - damage;
                        warShip.set(indexToFire, newIndex);
                        if (newIndex <= 0) {
                            System.out.println
                                    ("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commandList.get(1));
                    int endIndex = Integer.parseInt(commandList.get(2));
                    int damageDefend = Integer.parseInt(commandList.get(3));

                    if (startIndex >= 0 && startIndex < pirateShip.size() && endIndex >= 0
                            && endIndex < pirateShip.size() && startIndex >= endIndex) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int newIndex = pirateShip.get(i) - damageDefend;
                            if (newIndex <= 0) {
                                System.out.println
                                        ("You lost! The pirate ship has sunken.");
                                return;
                            }
                            pirateShip.set(i, newIndex);
                        }
                    }
                    break;
                case "Repair":
                    int startIndex1 = Integer.parseInt(commandList.get(1));
                    int health = Integer.parseInt(commandList.get(2));
                    if (startIndex1 >= 0 && startIndex1 < warShip.size()) {
                        int newHealth = pirateShip.get(startIndex1) + health;
                        if (newHealth <= healthCapacity) {
                            pirateShip.set(startIndex1, newHealth);
                        } else {
                            int unneeded = newHealth - healthCapacity;
                            newHealth -= unneeded;
                            pirateShip.set(startIndex1, newHealth);
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int item : pirateShip) {
                        if (item < healthCapacity * 0.20) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            commandList = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .collect(Collectors.toList());
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int item : pirateShip) {
            sum1 += item;
        }
        System.out.printf("Pirate ship status: %d%n", sum1);
        for (int item : warShip) {
            sum2 += item;
        }
        System.out.printf("Warship ship status: %d%n", sum2);
    }
}
