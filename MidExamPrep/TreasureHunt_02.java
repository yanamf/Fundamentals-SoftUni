package MidExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chestList = Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                .collect(Collectors.toList());

        List<String> commandList = Arrays.asList(scanner.nextLine().split(" "));

        while (!"Yohoho!".equals(commandList.get(0))) {
            String command = commandList.get(0);

            switch (command) {
                case "Loot":
                    List<String> loots = commandList.subList(1, commandList.size());
                    for (String item : loots) {
                        if (!chestList.contains(item)) {
                            chestList.add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandList.get(1));
                    if (index < chestList.size() && index >= 0) {
                        String indexToRemove = chestList.get(index);
                        chestList.remove(indexToRemove);
                        chestList.add(indexToRemove);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commandList.get(1));
                    int result = chestList.size() - count;
                    List<String> stolenItems = new ArrayList<>();

                    if (result >= 0) {
                        for (int i = result; i < chestList.size(); i++) {
                            String item = chestList.remove(i--);
                            stolenItems.add(item);
                        }
                    } else {
                        for (int i = 0; i < chestList.size(); i++) {
                            String indexToRemove = chestList.remove(i--);
                            stolenItems.add(indexToRemove);
                        }
                    }
                    System.out.println(String.join(", ", stolenItems));
                    break;
            }
            commandList = Arrays.asList(scanner.nextLine().split(" "));
        }
        if (chestList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (String item : chestList) {
                sum += item.length();
            }
            double averageGain = sum / chestList.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}


