package com.tpe.tdd;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;

    private Double balance;

    private Double dailyWithdrawalLimit;

    private Double dailyWithdrawnAmount = 0.0;

    private List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, Double balance, Double dailyWithdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }


    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double getDailyWithdrawalLimit() {
        return this.dailyWithdrawalLimit;
    }

    public List<String> getHistory() {
        return this.history;
    }

//    Functional methods
    public void deposit(Double amount) {

        if (amount > 0) {
            this.balance += amount;
            this.history.add("Deposit: " + amount);
        } else {
            throw new RuntimeException("Amount must be positive.");
        }
    }

    public boolean withdraw(Double amount) {

        if (amount > 0 && amount <= this.balance && (this.dailyWithdrawnAmount + amount) <= this.dailyWithdrawalLimit) {
            this.balance -= amount;
            this.dailyWithdrawnAmount += amount;
            this.history.add("Withdrawal: " + amount);
            return true;
        }
        return false;
    }
}
