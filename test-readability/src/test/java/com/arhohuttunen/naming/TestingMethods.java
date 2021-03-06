package com.arhohuttunen.naming;

import com.arhohuttunen.model.BankAccount;
import com.arhohuttunen.model.InsufficientFundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestingMethods {
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
}
