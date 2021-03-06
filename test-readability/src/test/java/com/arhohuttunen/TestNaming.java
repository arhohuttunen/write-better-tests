package com.arhohuttunen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestNaming {

    // Useless naming that doesn't mean anything at all

    @Test
    void test1() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    void test2() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void test3() {
        BankAccount account = new BankAccount(50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }

    // Naming the tests after the method being tested

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawFailure() {
        BankAccount account = new BankAccount(50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }

    // Naming after features being tested

    @Test
    void increasesBalanceWhenDepositIsMade() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    void decreasesBalanceWhenWithdrawalIsMade() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void throwsAnExceptionWhenWithdrawalIsMadeExceedingBalance() {
        BankAccount account = new BankAccount(50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }

    // Adding a better description with @DisplayName

    @Test
    @DisplayName("increases balance when a deposit is made")
    void increaseBalanceWhenDepositIsMade() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("decreases balance when a withdrawal is made")
    void decreaseBalanceWhenWithdrawalIsMade() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    @DisplayName("throws an exception when a withdrawal is made that exceeds balance")
    void throwAnExceptionWhenWithdrawalIsMadeExceedingBalance() {
        BankAccount account = new BankAccount(50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }
}
