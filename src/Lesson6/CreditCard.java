package Lesson6;

public class CreditCard {
    private String accNumber;
    private double amountCash = 0;

    public CreditCard(String accNumber, double amountCash) {
        if (amountCash < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");

        }
        this.accNumber = accNumber;
        this.amountCash = amountCash;
    }

    public void deposit (double depositCash) {
        amountCash += depositCash;
        System.out.println("Баланс пополнен на " + depositCash + " руб. Баланс составляет: " + amountCash + " руб.");
    }

    public void depositToCard(CreditCard other, double depositCash) {
        if (depositCash <= 0) {
            System.out.println("Сумма перевода должна быть положительной");
            return;
        }

        if (depositCash > this.amountCash) {
            System.out.println("Недостаточно средств для перевода");
            return;
        }
        this.amountCash -= depositCash;
        other.amountCash += depositCash;
        System.out.println("Перевод на " + depositCash + " руб. Баланс составляет: " + amountCash + " руб.");
    }

    public void withdrawal (double withdrawalCash) {
        if (amountCash < withdrawalCash) {
            System.out.println("Денежек не хватает, максимум можно снять " + amountCash + " руб.");
            return;
        }
        amountCash -= withdrawalCash;
        System.out.println("Снятие денег на " + withdrawalCash + " руб. Баланс составляет: " + amountCash + " руб.");
    }

    public void showInfo() {
        System.out.println("Лицевой счет пользователя: " + accNumber + ". Денежек на счете: " + amountCash + " руб.");
    }


}
