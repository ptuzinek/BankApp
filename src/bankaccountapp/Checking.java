package bankaccountapp;

public class Checking extends Account {
    // List PROPERTIES specific to checking account - debit card, pin , 2 as first character
    private static long debitCard = 123456789012L;
    private int pin;

    // CONSTRUCTOR to INITIALIZE checking account properties
    public Checking(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    // List METHODS specific to checking account
    public void showInfo() {
        System.out.println("\nAccount type: Checking");
        super.showInfo();
        System.out.println("Your Savings Account Features: " +
                "\n Debit Card Number: " + debitCard +
                "\n Debit Card PIN: " + pin);

    }

    // CHECKING Account 12 digit number for Debit Card and 4 digit PIN
    private void setDebitCard() {
        debitCard++;
        pin = (int) (Math.random() * Math.pow(10,4));
    }
}
