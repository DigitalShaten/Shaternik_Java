package Lesson6;

/**
 * Домашнее задание №6
 * @author Nikita Shaternik
 * 17.03.2026
 */

public class Lesson6 {
    public static void main(String[] args) {

        //Задача 1
        // Создали 3 карточки
        CreditCard bnb = new CreditCard("BNB - 3311", 40);
        CreditCard alfa = new CreditCard("ALFA - 2152", 3000);
        CreditCard prior = new CreditCard("PRIOR - 1333", 122.5);

        //Депозит на одну карту
        bnb.deposit(400);
        bnb.showInfo();
        printDash();

        //Депозит на вторую карту
        alfa.deposit(13.4);
        alfa.showInfo();
        printDash();

        //Снимаем с третьей
        prior.withdrawal(23.4);
        prior.showInfo();
        printDash();

        //Дополнительно: перевод с карты на карту
        bnb.showInfo();
        prior.showInfo();
        printDash();

        bnb.depositToCard(prior, 100);
        prior.showInfo();
        bnb.showInfo();

        System.out.println();

        //Задача 2
        ATM atm = new ATM(3,3,3);
        atm.withdraw(520);
        atm.addMoney(2,3,1);
        atm.withdraw(520);
        System.out.println();

    }

    public static void printDash() {
        System.out.println("--------------------------------------");
    }


    /*
    Задача *:
    Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
    задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
    метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
    принимает сумму денег, а возвращает булевое значение - успешность выполнения
    операции. При снятии денег, функция должна распечатывать каким количеством купюр
    какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
    количеством купюр каждого номинала. */
}
