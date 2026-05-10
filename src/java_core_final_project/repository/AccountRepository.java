package java_core_final_project.repository;

import java_core_final_project.exception.AccountNotFoundException;
import java_core_final_project.model.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private Map<String, Account> accounts = new HashMap<>();

    public AccountRepository() {
        initializeData();
    }

    private void initializeData() {
        accounts.put("12345-12345", new Account("12345-12345", 100));
        accounts.put("54321-54321", new Account("54321-54321", 500));
        accounts.put("11111-11111", new Account("11111-11111", 1000));
        accounts.put("22222-22222", new Account("22222-22222", 2500));
        accounts.put("33333-33333", new Account("33333-33333", 50));
        accounts.put("44444-44444", new Account("44444-44444", 10000));
        accounts.put("55555-55555", new Account("55555-55555", 300));
        accounts.put("66666-66666", new Account("66666-66666", 1500));
        accounts.put("77777-77777", new Account("77777-77777", 800));
        accounts.put("88888-88888", new Account("88888-88888", 2000));
        accounts.put("99999-99999", new Account("99999-99999", 450));
        accounts.put("10101-10101", new Account("10101-10101", 1200));
    }

    public Account getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
