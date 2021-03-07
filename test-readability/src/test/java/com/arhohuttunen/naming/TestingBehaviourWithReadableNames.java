package com.arhohuttunen.naming;

import com.arhohuttunen.BankAccount;
import com.arhohuttunen.InsufficientFundsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestingBehaviourWithReadableNames {
    @Test
    @DisplayName("increases balance when a deposit is made")
    void increasesBalanceWhenDepositIsMade() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("decreases balance when a withdrawal is made")
    void decreasesBalanceWhenWithdrawalIsMade() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    @DisplayName("throws an exception when a withdrawal is made that exceeds balance")
    void throwsAnExceptionWhenWithdrawalIsMadeExceedingBalance() {
        BankAccount account = new BankAccount(50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }
}
