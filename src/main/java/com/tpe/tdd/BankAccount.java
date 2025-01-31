package com.tpe.tdd;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;

    private Double balance;

    private Double dailyWithdrawalLimit;

    private Double dailyWithdrawalAmount;

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
}
