package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> travelRoute = Arrays.stream(scanner.nextLine()
                        .split("\\|\\|"))
                .collect(Collectors.toList());

        int fuel = Integer.parseInt(scanner.nextLine());
        int ammunition = Integer.parseInt(scanner.nextLine());

        while (!travelRoute.get(0).contains("Titan")) {

            if (travelRoute.get(0).contains("Travel")) {
                List<String> command = List.of(travelRoute.get(0).split(" "));
                int lightYears = Integer.parseInt(command.get(1));

                if (fuel >= lightYears) {
                    fuel -= lightYears;
                    System.out.printf("The spaceship travelled %d light-years.%n", lightYears);
                } else {
                    System.out.println("Mission Failed");
                    return;
                }
                travelRoute.remove(0);

            }
            if (travelRoute.get(0).contains("Enemy")) {
                List<String> command = List.of(travelRoute.get(0).split(" "));
                int enemyArmour = Integer.parseInt(command.get(1));

                if (ammunition >= enemyArmour) {
                    ammunition -= enemyArmour;
                    System.out.printf("An enemy with %d armour is defeated.%n",
                            enemyArmour);
                } else {
                    int consume = enemyArmour * 2;
                    if (fuel >= consume) {
                        fuel -= consume;
                        System.out.printf("An enemy with %d armour is outmaneuvered.%n",
                                enemyArmour);
                    } else {
                        System.out.println("Mission failed.");
                        return;
                    }
                }
                travelRoute.remove(0);
            }
            if (travelRoute.get(0).contains("Repair")) {
                List<String> command = List.of(travelRoute.get(0).split(" "));
                int add = Integer.parseInt(command.get(1));

                fuel += add;
                ammunition += add * 2;
                System.out.printf("Ammunitions added: %d.%n", add * 2);
                System.out.printf("Fuel added: %d.%n", add);
                travelRoute.remove(0);
            }

        }


        System.out.println("You have reached Titan, all passengers are safe.");

    }
}
