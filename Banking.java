import java.util.Scanner;

public class Banking {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Create an account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Print account");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\nEnter account number: ");
                    String accountNumber = input.nextLine();
                    System.out.print("Enter initial amount: ");
                    double initialBalance = input.nextDouble();
                    input.nextLine();
                    bank.addAccount(new Account(accountNumber, initialBalance));
                    break;
                case 2:
                    System.out.print("\nEnter account number: ");
                    accountNumber = input.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    input.nextLine();
                    bank.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("\nEnter account number: ");
                    accountNumber = input.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    input.nextLine();
                    bank.withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("\nEnter account number: ");
                    accountNumber = input.nextLine();
                    System.out.print("Enter destination account number: ");
                    String destinationAccountNumber = input.nextLine();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = input.nextDouble();
                    input.nextLine();
                    bank.transfer(accountNumber, destinationAccountNumber, transferAmount);
                    break;
                case 5:
                    System.out.print("\nEnter account number: ");
                    accountNumber = input.nextLine();
                    Account account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("\nAccount number: " + account.getAccountNumber());
                        System.out.println("Balance: $" + formatBalance(account.getBalance()));
                    }
                    else {
                        System.out.println("\nAccount not found.");
                    }
                    break;
                case 6:
                    System.out.println("\nExiting to Main Menu...");
                    input.close();
                    return;
                default:
                    System.out.println("\nInvalid Option. Try again.");
                    break;
            }
        }
    }

    private static String formatBalance (double value) {
        return String.format("%.2f", value);
    }
}
