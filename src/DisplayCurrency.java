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

    public void displayMenu() {

        System.out.println(CYAN + "\n========== Currency Menu ==========" + RESET);
        System.out.println(YELLOW + "1. US Dollar ($)" + RESET);
        System.out.println(YELLOW + "2. Japanese Yen (¥)" + RESET);
        System.out.println(YELLOW + "3. Indian Rupee (₹)" + RESET);
        System.out.println(YELLOW + "4. Exit" + RESET);
        System.out.println(CYAN + "===================================" + RESET);

        choice = getSafeInt("Enter Choice: ");

        while (choice < 1 || choice > 4) {
            System.out.println(RED + "Invalid menu choice! Please choose between 1–4." + RESET);
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
        System.out.println(CYAN + "\n=========== Loan EMI Details ===========" + RESET);

        System.out.printf("Principal Amount     : %s" + BLUE + "%.2f" + RESET + "\n", symbol, principal);
        System.out.printf("Rate of Interest     : " + BLUE + "%.2f%%" + RESET + "\n", rate);
        System.out.printf("Time Period          : " + BLUE + "%d years" + RESET + "\n", time);
        System.out.printf("Simple Interest      : %s" + BLUE + "%.2f" + RESET + "\n", symbol, simpleInterest);
        System.out.printf("Total Amount Payable : %s" + BLUE + "%.2f" + RESET + "\n", symbol, totalAmount);
        System.out.printf("Months               : " + BLUE + "%d" + RESET + "\n", months);
        System.out.printf("Monthly EMI          : %s" + BLUE + "%.2f" + RESET + "\n", symbol, emi);

        System.out.println(CYAN + "========================================" + RESET);
    }

    public void call() {
        while (true) {
            displayMenu();

            if (choice == 4) {
                System.out.println(MAGENTA + "Thanks For Using Simple Loan EMI Calculator!" + RESET);
                break;
            }

            displayAttributes();
            calculateEMI();
            selectCharacter();
            displayAll();
        }
    }
}
