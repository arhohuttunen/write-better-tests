package com.arhohuttunen.naming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RandomNaming {
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
}
