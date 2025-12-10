import java.util.InputMismatchException;
import java.util.Scanner;

class DisplayCurrency extends Error {

    int choice;
    double principal;
    double rate;
    int time;
    double simpleInterest;
    double totalAmount;
    int months;
    double emi;
    String symbol;

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Choice          Currency");
        System.out.println("------------------------------------");
        System.out.println("1.              US Dollar ($)");
        System.out.println("2.              Japanese Yen (¥)");
        System.out.println("3.              Indian Rupee (₹)");
        System.out.println("4.              Exit");
        System.out.println("------------------------------------");

        choice = getSafeInt("Enter Choice: ");

        while (choice < 1 || choice > 4) {
            System.out.println("Invalid menu choice! Please choose between 1–4.");
            choice = getSafeInt("Enter Choice: ");
        }
    }

    public void displayAttributes() {
        principal = getSafeDouble("Enter Principal Amount: ");
        rate = getSafeDouble("Enter Yearly Interest Rate (%): ");
        time = getSafeInt("Enter Time Period (Years): ");

        months = time * 12;
    }

    public void calculateEMI() {
        simpleInterest = (principal * rate * time) / 100;
        totalAmount = principal + simpleInterest;
        emi = totalAmount / months;
    }

    public void selectCharacter() {
        switch (choice) {
            case 1: symbol = "$"; break;
            case 2: symbol = "¥"; break;
            case 3: symbol = "₹"; break;
            default: symbol = ""; break;
        }
    }

    public void displayAll() {
        System.out.println("\n------ Loan EMI Details ------");
        System.out.printf("Principal Amount     : %s%.2f\n", symbol, principal);
        System.out.printf("Rate of Interest     : %.2f%%\n", rate);
        System.out.printf("Time Period          : %d years\n", time);
        System.out.printf("Simple Interest      : %s%.2f\n", symbol, simpleInterest);
        System.out.printf("Total Amount Payable : %s%.2f\n", symbol, totalAmount);
        System.out.printf("Months               : %d\n", months);
        System.out.printf("Monthly EMI          : %s%.2f\n", symbol, emi);
        System.out.println("--------------------------------");
    }

    public void call() {

        while (true) {
            displayMenu();

            if (choice == 4) {
                System.out.println("Thanks For Using Simple Loan EMI Calculator");
                break;
            }

            displayAttributes();
            calculateEMI();
            selectCharacter();
            displayAll();
        }
    }
}
