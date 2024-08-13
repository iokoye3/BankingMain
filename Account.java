public class Account {
    private String accountNumber;
    private double balance;


    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposit successful. New balance: $" + formatBalance(balance));
        }
        else {
            System.out.println("\nDeposit unsuccessful.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nWithdrawal successful. New balance: $" + formatBalance(balance));
        }
        else {
            System.out.println("\nWithdrawal unsuccessful.");
        }
    }

    public void transfer(Account target, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            target.deposit(amount);
            System.out.println("\nTransfer successful. New balance: $" + formatBalance(balance));
        }
        else {
            System.out.println("\nTransfer unsuccessful.");
        }
    }

    private String formatBalance (double value) {
        return String.format("%.2f", value);
    }
}
