package com.arhohuttunen.intent;

import com.arhohuttunen.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssertionMessages {
    @Test
    void increasesBalanceWhenDepositIsMade() {
        BankAccount account = new BankAccount(100);
        account.deposit(100);
        assertEquals(200, account.getBalance(), "Account balance after deposit");
    }
}
