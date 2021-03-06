package com.arhohuttunen.model;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (balance - amount < 0) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
