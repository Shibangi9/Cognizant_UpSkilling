import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a year
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Check whether the year is a leap year
        if (year % 400 == 0) {
            System.out.println(year + " is a Leap Year.");
        }
        else {
            if (year % 100 == 0) {
                System.out.println(year + " is NOT a Leap Year.");
            }
            else {
                if (year % 4 == 0) {
                    System.out.println(year + " is a Leap Year.");
                }
                else {
                    System.out.println(year + " is NOT a Leap Year.");
                }
            }
        }

        sc.close();
    }
}