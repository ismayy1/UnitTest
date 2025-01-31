package tdd;

import com.tpe.tdd.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
