import java.util.InputMismatchException;
import java.util.Scanner;

class Error extends Colors {
    Scanner sc = new Scanner(System.in);

    // SAFE integer input
    public int getSafeInt(String message) {
        while (true) {
            System.out.print(GREEN + message + RESET);
            try {
                int value = sc.nextInt();
                if (value < 0) {
                    System.out.println(RED + "Please enter a positive value!" + RESET);
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input! Please enter a valid number." + RESET);
                sc.next(); // clear bad input
            }
        }
    }

    // SAFE double input
    public double getSafeDouble(String message) {
        while (true) {
            System.out.print(GREEN + message + RESET);
            try {
                double value = sc.nextDouble();
                if (value < 0) {
                    System.out.println(RED + "Please enter a positive value!" + RESET);
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input! Please enter a valid number." + RESET);
                sc.next();
            }
        }
    }
}
