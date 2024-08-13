import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.*;

public class TestBank {
     @Test
    public void testAddAccount() {
        Bank bank = new Bank();
        Account account = new Account("12345", 100.00);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("12345"));
    }

    @Test
    public void testDepositToExistingAccount() {
        Bank bank = new Bank();
        Account account = new Account("12345", 100.00);
        bank.addAccount(account);
        bank.deposit("12345", 50.00);
        assertEquals(150.00, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositToNonExistingAccount() {
        Bank bank = new Bank();
        bank.deposit("12345", 50.00);
        assertNull(bank.getAccount("12345"));
    }

    @Test
    public void testWithdrawFromExistingAccount() {
        Bank bank = new Bank();
        Account account = new Account("12345", 100.00);
        bank.addAccount(account);
        bank.withdraw("12345", 50.00);
        assertEquals(50.00, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawFromNonExistingAccount() {
        Bank bank = new Bank();
        bank.withdraw("12345", 50.00);
        assertNull(bank.getAccount("12345"));
    }

    @Test
    public void testTransferBetweenExistingAccounts() {
        Bank bank = new Bank();
        Account account1 = new Account("12345", 100.00);
        Account account2 = new Account("67890", 50.00);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.transfer("12345", "67890", 50.00);
        assertEquals(50.00, account1.getBalance(), 0.001);
        assertEquals(100.00, account2.getBalance(), 0.001);
    }

    @Test
    public void testTransferFromNonExistingAccount() {
        Bank bank = new Bank();
        Account account2 = new Account("67890", 50.00);
        bank.addAccount(account2);
        bank.transfer("12345", "67890", 50.00);
        assertEquals(50.00, account2.getBalance(), 0.001);
    }

    @Test
    public void testTransferToNonExistingAccount() {
        Bank bank = new Bank();
        Account account1 = new Account("12345", 100.00);
        bank.addAccount(account1);
        bank.transfer("12345", "67890", 50.00);
        assertEquals(100.00, account1.getBalance(), 0.001);
    }
}
