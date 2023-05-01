package AssociativeArrays.MoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            //{contest}:{password for contest}
            String[] tokens = input.split(":");
            String contestName = tokens[0];
            String password = tokens[1];

            contests.put(contestName, password);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            //{contest}=>{password}=>{username}=>{points}
            String[] tokens2 = input.split("=>");
            String contest = tokens2[0];
            String passCheck = tokens2[1];
            String username = tokens2[2];
            int userPoints = Integer.parseInt(tokens2[3]);

            if (contests.containsKey(contest)) {
                if (contests.get(contest).equals(passCheck)) {
                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contest, userPoints);
                    if (!users.containsKey(username)) {
                        users.put(username, course);
                    } else {
                        if (!users.get(username).containsKey(contest)) {
                            users.get(username).put(contest, userPoints);
                        } else {
                            users.get(username)
                                    .put(contest, Math.max
                                            (userPoints, users.get(username)
                                                    .get(contest)));
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
            if (entry.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", entry.getKey(), totalSum);
            }
        }
        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
                    .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
    }

}
