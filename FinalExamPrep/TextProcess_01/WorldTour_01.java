package FinalExamPrep.TextProcess_01;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        StringBuilder stops = new StringBuilder(input);

        while (!command.equals("Travel")) {
            String[] code = command.split(":");
            String action = code[0];
            if ("Add Stop".equals(action)) {
                int index = Integer.parseInt(code[1]);
                String place = code[2];
                if (index >= 0 && index <= stops.length() - 1) {
                    stops.insert(index, place);
                }
                System.out.println(stops);
            }
            else if ("Remove Stop".equals(action)) {
                int startIndex = Integer.parseInt(code[1]);
                int endIndex = Integer.parseInt(code[2]);
                if (startIndex >= 0 && startIndex <= stops.length() - 1
                        && endIndex >= 0 && endIndex <= stops.length() - 1 ) {
                    stops.replace(startIndex, endIndex + 1, "");
                }
                System.out.println(stops);
            } else if ("Switch".equals(action)) {
                String oldString = code[1];
                String newString = code[2];

                String newStops = stops.toString();
                if (newStops.contains(oldString)) {
                    newStops = newStops.replace(oldString, newString);
                    stops = new StringBuilder(newStops);
                }
                System.out.println(newStops);
            }

            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}

