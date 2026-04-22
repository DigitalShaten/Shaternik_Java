package java_core_final_project.model;

import java_core_final_project.exception.InsufficientFundsException;
import java_core_final_project.exception.InvalidAmountException;

//счет-баланс
public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit (int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Введенная сумма должна быть больше 0: " + amount);
        }
        balance += amount;
    }

    public void withdraw (int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Введенная сумма должна быть больше 0: " + amount);
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Сумма снятия " + amount + " превышает баланс в " + balance + " руб.");
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
