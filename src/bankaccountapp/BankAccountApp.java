package bankaccountapp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) throws IOException {
        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\Przemek\\Downloads\\original.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String SSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, SSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, SSN, initDeposit));

            }
            else System.out.println("ERROR READING ACCOUNT TYPE");
        }

        accounts.get(5).showInfo();

        for (Account acc : accounts) {
            System.out.println("\n**************************");
            acc.showInfo();
        }




        // Test and try to create new accounts
  /*      Checking chkacc1 = new Checking("Tom Wilson", "3214567879", 1500);

        Savings savacc1 = new Savings("Rich Love", "456657897", 2500);

        savacc1.showInfo();
        System.out.println("***********************************");
        chkacc1.showInfo();
        System.out.println("***********************************");
        savacc1.compound();
        System.out.println("***********************************");

        savacc1.transfer(200, chkacc1);*/


        // Read a CSV file, then create new accounts based on that data

    }


}
