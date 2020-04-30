package bankaccountapp;

public class Savings extends Account {
    // List PROPERTIES specific to the Savings account
    private static int safetyDepositBoxID = 100;
    private int safetyDepositBoxKey;

    // CONSTRUCTOR to INITIALIZE PROPERTIES for the Saving account
    public Savings(String name, String SSN, double initDeposit) {
        super(name, SSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBoxID();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    // List METHODS specific to the Savings account
    public void showInfo() {
        System.out.println("\nAccount type: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features: " +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
    }
    // SAVING Account - create 3digit-number for Safety Deposit Box
    // and 4 digit code to access it
    private void setSafetyDepositBoxID() {
        safetyDepositBoxID++;
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

}
