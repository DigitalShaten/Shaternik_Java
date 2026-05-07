package java_core_final_project.service;

import java_core_final_project.exception.AccountNotFoundException;
import java_core_final_project.exception.InvalidAmountException;
import java_core_final_project.model.Account;
import java_core_final_project.model.Transaction;
import java_core_final_project.model.TransactionStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class TransferService {
    private final Map<String, Account> accounts;

    public TransferService (Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Transaction transfer(
            String fromAccountNumber,
            String toAccountNumber,
            int amount
    ) {
        try {
            Account fromAccount = findAccount(fromAccountNumber);
            Account toAccount = findAccount(toAccountNumber);

            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.SUCCESS,
                    LocalDateTime.now()
            );
        } catch (AccountNotFoundException | InvalidAmountException exception){
            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.ERROR,
                    LocalDateTime.now()
            );
        }
    }

    private Account findAccount (String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Аккаунт не найден: " + accountNumber);
        }
        return account;
    }
}
