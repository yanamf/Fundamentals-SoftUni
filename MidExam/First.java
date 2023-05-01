package MidExam;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numBiscuitsWorkerPerDay = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());
        int numberBiscuitsCompetitors30Days = Integer.parseInt(scanner.nextLine());

        int result = 0;
        for (int i = 1; i <= 30; i++) {

            if (i % 3 == 0) {
                result += (numBiscuitsWorkerPerDay * countWorkers * 0.75);
            } else {
                result += (numBiscuitsWorkerPerDay * countWorkers);
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", result);

        double diff = Math.abs(result - numberBiscuitsCompetitors30Days);
        double percent = diff / numberBiscuitsCompetitors30Days * 100;

        if (result>numberBiscuitsCompetitors30Days){
            System.out.printf("You produce %.2f percent more biscuits.", percent);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", percent);
        }

    }
}
