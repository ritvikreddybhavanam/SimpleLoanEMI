class Main {
    public static void main(String[] args) {
        DisplayWelcomeMessage displayWelcomeMessage = new DisplayWelcomeMessage();
        displayWelcomeMessage.displayMessage();
        DisplayCurrency currency = new DisplayCurrency();
        currency.call();
    }
}