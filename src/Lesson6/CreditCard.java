package Lesson6;

public class CreditCard {
    /*
    Задача 1:
    Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
    метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
    который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
    выводит текущую информацию о карточке. Напишите программу, которая создает три
    объекта класса CreditCard у которых заданы номер счета и начальная сумма.
    Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
    третьей. Выведите на экран текущее состояние всех трех карточек. */

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
        System.out.println("Перевод на карту " + other.accNumber + ". Депозит: " + depositCash + " руб. Баланс составляет: " + amountCash + " руб.");
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
