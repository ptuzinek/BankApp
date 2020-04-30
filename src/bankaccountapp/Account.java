package bankaccountapp;

public abstract class Account implements IBaseRate {
    // ABSTRACT - we are not able to create objects from this class
    // BUT we can create objects from classes that inherit from this class - Checking and Savings

    // What will be common to both accounts?
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // List COMMON PROPERTIES for savings and checking accounts
    private String name;
    private String SSN;
    private double balance;
    private static int index = 10000;
    protected String accountNumber = "";
    protected double rate;

    //private int initialDeposit;


    // CONSTRUCTOR to set base properties and initialize the account
    public Account(String name, String SSN, double initDeposit) {
        this.name = name;
        this.SSN = SSN;
        balance = initDeposit;

        // Set Account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();


    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = SSN.substring(SSN.length()-2, SSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest: $" + accruedInterest);
        balance += accruedInterest;
        printBalance();
    }

    // List COMMON METHODS
    public void deposit(double ammount){
        balance += ammount;
        printBalance();
    }

    public void withdraw(double ammount){
        balance -= ammount;
        printBalance();
    }

    public void transfer(double ammount, Account target){
        balance -= ammount;
        target.deposit(ammount);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance is now: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "Name: " + name +
                        "\nAccount Number: " + accountNumber +
                        "\nBalance: " + balance +
                        "\nRate: " + rate
        );


    }
}
