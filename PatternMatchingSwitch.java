public class PatternMatchingSwitch {

    public static void printType(Object obj) {

        if (obj instanceof Integer) {
            System.out.println("Integer value: " + obj);
        }
        else if (obj instanceof String) {
            System.out.println("String value: " + obj);
        }
        else if (obj instanceof Double) {
            System.out.println("Double value: " + obj);
        }
        else if (obj == null) {
            System.out.println("Null value");
        }
        else {
            System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {

        printType(100);
        printType("Hello Java");
        printType(25.5);
        printType(null);
    }
}