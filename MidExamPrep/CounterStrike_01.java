package MidExamPrep;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int totalEnergy = initialEnergy;
        int wonBattles = 0;

        while (!command.equals("End of battle")) {
            int currentEnergy = Integer.parseInt(command);
            if (totalEnergy - currentEnergy < 0) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        wonBattles, totalEnergy);
                return;
            } else {
                totalEnergy -= currentEnergy;
                wonBattles++;
                if (wonBattles % 3 == 0) {
                    totalEnergy += wonBattles;
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", wonBattles, totalEnergy);
    }
}

