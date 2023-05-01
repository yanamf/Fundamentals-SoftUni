package MidExamPrep;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeCapacity1 = Integer.parseInt(scanner.nextLine());
        int employeeCapacity2 = Integer.parseInt(scanner.nextLine());
        int employeeCapacity3 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        int employeesCapacityAnHour = employeeCapacity1 + employeeCapacity2 + employeeCapacity3;

        while (studentsCount > 0) {
            studentsCount -= employeesCapacityAnHour;
            hours++;
            if (hours % 4 == 0) {
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
