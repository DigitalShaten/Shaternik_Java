package java_core_final_project.model;

import java_core_final_project.exception.InsufficientFundsException;
import java_core_final_project.exception.InvalidAmountException;

public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit (int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("неверная сумма перевода");
        }
        balance += amount;
    }

    public void withdraw (int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("неверная сумма перевода");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("ошибка во время обработки");
        }
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
