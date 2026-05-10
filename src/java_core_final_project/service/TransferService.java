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

    public synchronized Transaction transfer(
            String fromAccountNumber,
            String toAccountNumber,
            double amount
    ) {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Сумма перевода должна быть положительной: " + amount);
            }

            if (fromAccountNumber.equals(toAccountNumber)) {
                throw new IllegalArgumentException("Счет отправителя и получателя совпадают");
            }

            Account fromAccount = accountRepository.getAccountByNumber(fromAccountNumber);
            Account toAccount = accountRepository.getAccountByNumber(toAccountNumber);

            if (fromAccount == null) {
                throw new AccountNotFoundException("Счет отправителя не найден: " + fromAccountNumber);
            }
            if (toAccount == null) {
                throw new AccountNotFoundException("Счет получателя не найден: " + toAccountNumber);
            }

            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            accountRepository.updateAccount(fromAccount);
            accountRepository.updateAccount(toAccount);

            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.SUCCESS,
                    "Успешно обработан",
                    LocalDateTime.now()
            );

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientFundsException | IllegalArgumentException e) {
            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.ERROR,
                    e.getMessage(),
                    LocalDateTime.now()
            );
        } catch (Exception e) {
            return new Transaction(
                    fromAccountNumber,
                    toAccountNumber,
                    amount,
                    TransactionStatus.ERROR,
                    "Внутренняя ошибка системы: " + e.getMessage(),
                    LocalDateTime.now()
            );
        }
    }
}
