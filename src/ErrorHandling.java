import java.util.InputMismatchException;
import java.util.Scanner;

class Error {
    Scanner sc = new Scanner(System.in);
    // SAFE integer input
    public int getSafeInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = sc.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a positive value!");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next(); // clear bad input
            }
        }
    }

    // SAFE double input
    public double getSafeDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = sc.nextDouble();
                if (value < 0) {
                    System.out.println("Please enter a positive value!");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();
            }
        }
    }
}