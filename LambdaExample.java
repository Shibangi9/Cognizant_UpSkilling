import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        Collections.sort(fruits, (a, b) -> a.compareTo(b));

        System.out.println("Sorted List:");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}