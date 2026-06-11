public class OperatorPrecedence {

    public static void main(String[] args) {

        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 20 / 5 + 3 * 4;
        int result4 = 8 + 12 / 3 - 2;

        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("20 / 5 + 3 * 4 = " + result3);
        System.out.println("8 + 12 / 3 - 2 = " + result4);

        System.out.println("\nExplanation:");
        System.out.println("Multiplication and division are evaluated before addition and subtraction.");
        System.out.println("Parentheses have the highest precedence and are evaluated first.");
    }
}