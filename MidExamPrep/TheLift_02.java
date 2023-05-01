package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());

        int[] lift = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int peopleInLift = Arrays.stream(lift).sum();

        if (waitingPeople + peopleInLift > lift.length * 4) {
            int peopleInQueue = waitingPeople + peopleInLift - (lift.length * 4);
            System.out.printf("There isn't enough space! %d people in a queue!%n",
                    peopleInQueue);
            int[] fullLift = new int[lift.length];
            Arrays.fill(fullLift, 4);
            for (int element : fullLift) {
                System.out.print(element + " ");
            }
            return;
        }
        for (int i = 0; i < lift.length; i++) {
            if (lift[i] == 4 || waitingPeople == 0) {
                continue;
            }
            if (lift[i] == 0 && waitingPeople >= 4) {
                lift[i] += 4;
                waitingPeople -= 4;
            } else if (waitingPeople <= 4) {
                lift[i] += waitingPeople;
            }
        }
        if (lift.length * 4 > 0 && waitingPeople < 4 && waitingPeople != 0) {
            System.out.println("The lift has empty spots!");
        }
        for (int fin: lift){
            System.out.print(fin + " ");
        }
    }
}
