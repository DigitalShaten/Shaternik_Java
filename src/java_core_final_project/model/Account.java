package java_core_final_project.model;

//счет-баланс
public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit (int money) {
        balance += money;
        System.out.println("Пополнение счета на: " + money + " руб. На балансе сейчас: " + balance + " руб.");
    }

    public void withdraw (int money) {
        if (balance < money) return;
        balance -= money;
        System.out.println("Снятие со счета на: " + money + " руб. На балансе сейчас: " + balance + " руб.");
    }
}
