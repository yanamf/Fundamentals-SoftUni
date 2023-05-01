package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phones = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            List<String> elements = List.of(command.split("\\s+"));
            switch (elements.get(0)) {
                case "Add":
                    if (!phones.contains(elements.get(2))) {
                        phones.add(elements.get(2));
                    }
                    break;
                case "Remove":
                    if (!phones.contains(elements.get(2))) {
                        break;
                    } else {
                        phones.remove(elements.get(2));
                    }
                    break;
                case "Bonus":
                    List<String> thirdIndex = List.of(elements.get(3).split("\\:"));
                    String oldPhone = thirdIndex.get(0);
                    String newPhone = thirdIndex.get(1);
                    if (phones.contains(oldPhone)) {
                        int position = phones.indexOf(oldPhone);
                        phones.add(position + 1, newPhone);
                    }
                    break;
                case "Last":
                    if (phones.contains(elements.get(2))){
                        int position = phones.indexOf(elements.get(2));
                        String phone = elements.get(2);
                        phones.remove(position);
                        phones.add(phone);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", phones));
    }
}
