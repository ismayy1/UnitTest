package tdd;

import com.tpe.tdd.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBankAccount {

    /*
        ****************************
            Bank Account Application
        ****************************

        Methods to be created in the application:
        * Create Account
        * Withdraw Money (Insufficient balance check, Daily Withdrawal Limit Check, Negative Entry check)
        * Deposit Money (Negative Entry Check)
        * Control for Retrieving Account History
     */

    @Test
    void testCreateAccount() {
        BankAccount bankAccount = new BankAccount("12345", 0.0, 1000.00);

        assertNotNull(bankAccount.getAccountNumber());

        assertEquals("12345", bankAccount.getAccountNumber());
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals(1000.0, bankAccount.getDailyWithdrawalLimit());
    }

    @Test
    void testDeposit() {
//        If we had BDD, this would be our "given" part.
        BankAccount bankAccount = new BankAccount("12345", 0.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();

//        Then this would be "when" part.
        bankAccount.deposit(200.0);

//        "Then" part.
        assertEquals(200.0, bankAccount.getBalance());
        assertEquals(initialHistorySize + 1, bankAccount.getHistory().size());
    }

    @Test
    void testDepositWithNonPositiveAmount() {
        BankAccount bankAccount = new BankAccount("12345", 0.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();

//        bankAccount.deposit(-200.0);

        assertThrows(RuntimeException.class, () -> bankAccount.deposit(-200.0));
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals(initialHistorySize, bankAccount.getHistory().size());
    }

    @Test
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount("12345", 500.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();
        assertTrue(bankAccount.withdraw(200.0));
        assertEquals(300.0, bankAccount.getBalance());
        assertEquals(initialHistorySize + 1, bankAccount.getHistory().size());
    }

    @Test
    void testWithdrawWhenInsufficientBalance() {
        BankAccount bankAccount = new BankAccount("12345", 500.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();
        assertFalse(bankAccount.withdraw(600.0));
        assertEquals(500.0, bankAccount.getBalance());
        assertEquals(initialHistorySize, bankAccount.getHistory().size());
    }

    @Test
    void testWithdrawWhenAmountOverDailyLimit() {
        BankAccount bankAccount = new BankAccount("12345", 1500.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();

        assertTrue(bankAccount.withdraw(1000.0));
        assertFalse(bankAccount.withdraw(100.0));   // Withdraw not available
        assertEquals(500.0, bankAccount.getBalance());
        assertEquals(initialHistorySize + 1, bankAccount.getHistory().size());
    }

    @Test
    void testWithdrawWithOnePositiveAmount() {
        BankAccount bankAccount = new BankAccount("12345", 500.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();
        assertFalse(bankAccount.withdraw(-200.0));
        assertEquals(500.0, bankAccount.getBalance());
        assertEquals(initialHistorySize, bankAccount.getHistory().size());
    }

    @Test
    void testGetAccountTransactionHistory() {
        BankAccount bankAccount = new BankAccount("12345", 500.0, 1000.0);
        int initialHistorySize = bankAccount.getHistory().size();

        bankAccount.withdraw(200.0);    // Size + 1
        bankAccount.deposit(500.0); // Size + 1

        assertEquals(initialHistorySize + 2, bankAccount.getHistory().size());
        assertTrue(bankAccount.getHistory().contains("Withdrawal: " + 200.0));
    }
}
