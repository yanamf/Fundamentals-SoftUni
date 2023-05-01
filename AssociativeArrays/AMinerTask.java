package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> collection = new LinkedHashMap<>();
        
        while (!input.equals("stop")){

            String resource = input;
            String quantity = scanner.nextLine();

            if (!collection.containsKey(resource)){
                collection.put(resource, Integer.valueOf(quantity));
            } else {
                int newQuantity = Integer.parseInt(quantity);
                collection.put(resource, collection.get(resource)+ newQuantity);
            }
            
            input = scanner.nextLine();
        }
        collection.forEach((String, Integer) -> System.out.println(String + " -> "
                + Integer));
    }
}
