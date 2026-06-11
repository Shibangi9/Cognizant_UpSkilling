public class TypeCastingExample {

    public static void main(String[] args) {

        // Double to int
        double d = 45.89;
        int i = (int) d;

        // Int to double
        int num = 25;
        double result = (double) num;

        System.out.println("Original double value: " + d);
        System.out.println("Double converted to int: " + i);

        System.out.println("Original int value: " + num);
        System.out.println("Int converted to double: " + result);
    }
}