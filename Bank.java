import java.util.HashMap;
import java.util.Map;

public class Bank {
    Map<String,Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("\nAccount added: " + account.getAccountNumber());
        System.out.println("Initial balance: $" + formatBalance(account.getBalance()));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
   
    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);

        if (account != null) {
            account.deposit(amount);
        }
        else {
            System.out.println("\nAccount not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);

        if (account != null) {
            account.withdraw(amount);
        }
        else {
            System.out.println("\nAccount not found.");
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        Account targetAccount = accounts.get(fromAccount);
        Account destAccount = accounts.get(toAccount);

        if (targetAccount != null && destAccount != null) {
            targetAccount.transfer(destAccount, amount);
        }
        else {
            System.out.println("\nAccount(s) not found.");
        }
    }

    private String formatBalance (double value) {
        return String.format("%.2f", value);
    }
}
