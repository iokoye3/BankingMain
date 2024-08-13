import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestAccount {
    @Test
    public void testDeposit() {
        Account account = new Account("1", 100.00);
        account.deposit(150.00);
        assertEquals(250.00, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositZeroAmount() {
        Account account = new Account("12345", 100.00);
        account.deposit(0.00);
        assertEquals(100.00, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegativeAmount() {
        Account account = new Account("12345", 100.00);
        account.deposit(-50.00);
        assertEquals(100.00, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawPositiveAmount() {
        Account account = new Account("12345", 100.00);
        account.withdraw(50.00);
        assertEquals(50.00, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Account account = new Account("12345", 100.00);
        account.withdraw(150.00);
        assertEquals(100.00, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Account account = new Account("12345", 100.00);
        account.withdraw(-50.00);
        assertEquals(100.00, account.getBalance(), 0.001);
    }

    @Test
    public void testTransferSufficientFunds() {
        Account account1 = new Account("12345", 100.00);
        Account account2 = new Account("67890", 50.00);
        account1.transfer(account2, 50.00);
        assertEquals(50.00, account1.getBalance(), 0.001);
        assertEquals(100.00, account2.getBalance(), 0.001);
    }

    @Test
    public void testTransferInsufficientFunds() {
        Account account1 = new Account("12345", 100.00);
        Account account2 = new Account("67890", 50.00);
        account1.transfer(account2, 150.00);
        assertEquals(100.00, account1.getBalance(), 0.001);
        assertEquals(50.00, account2.getBalance(), 0.001);
    }

    @Test
    public void testTransferNegativeAmount() {
        Account account1 = new Account("12345", 100.00);
        Account account2 = new Account("67890", 50.00);
        account1.transfer(account2, -50.00);
        assertEquals(100.00, account1.getBalance(), 0.001);
        assertEquals(50.00, account2.getBalance(), 0.001);
    }
}
