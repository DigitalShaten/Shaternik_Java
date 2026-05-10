package java_core_final_project.service;

import java_core_final_project.exception.AccountNotFoundException;
import java_core_final_project.exception.InsufficientFundsException;
import java_core_final_project.exception.InvalidAmountException;
import java_core_final_project.model.Account;
import java_core_final_project.model.Transaction;
import java_core_final_project.model.TransactionStatus;
import java_core_final_project.repository.AccountRepository;

import java.time.LocalDateTime;

public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Transaction transfer(
            String fromAccountNumber,
            String toAccountNumber,
            double amount
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
                    "успешно обработан",
                    LocalDateTime.now()
            );
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientFundsException exception){
            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.ERROR,
                    exception.getMessage(),
                    LocalDateTime.now()
            );
        }
    }

    private Account findAccount(String accountNumber) {
        Account account = accountRepository.getAccountByNumber(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Аккаунт не найден: " + accountNumber);
        }
        return account;
    }


}
