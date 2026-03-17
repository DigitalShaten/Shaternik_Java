package Lesson6;

public class ATM {

    /*
    Задача *:
    Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
    задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
    метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
    принимает сумму денег, а возвращает булевое значение - успешность выполнения
    операции. При снятии денег, функция должна распечатывать каким количеством купюр
    какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
    количеством купюр каждого номинала. */

    int count20 = 5;
    int count50 = 5;
    int count100 = 3;

    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
    }

    public void addMoney(int add20, int add50, int add100) {
        count20 += add20;
        count50 += add50;
        count100 += add100;
        System.out.printf("Пополнение банкомата! Сейчас в банкомате %d шт - 20 рублей, %d шт - 50 рублей, %d шт - 100 рублей.%n", add20, add50, add100);
    }

    public boolean withdraw(int amount) {
        int originalAmount = amount;

        if (amount > (count20 * 20 + count50 * 50 + count100 * 100)) {
            System.out.printf("Для выдачи %d рублей в банкомате не хватает купюр.%n", amount);
            return false;
        }

        // перебираем 100
        for (int use100 = Math.min(amount / 100, count100); use100 >= 0; use100--) {

            int remainingAfter100 = amount - use100 * 100;

            // перебираем 50
            for (int use50 = Math.min(remainingAfter100 / 50, count50); use50 >= 0; use50--) {

                int remainingAfter50 = remainingAfter100 - use50 * 50;

                // считаем 20
                int use20 = Math.min(remainingAfter50 / 20, count20);
                int remainingAfter20 = remainingAfter50 - use20 * 20;

                if (remainingAfter20 == 0) {
                    count100 -= use100;
                    count50 -= use50;
                    count20 -= use20;

                    System.out.printf(
                            "Сумма %d выдана: купюр в 100 - %d шт, купюр в 50 - %d шт, купюр в 20 - %d шт%n",
                            originalAmount, use100, use50, use20
                    );
                    return true;
                }
            }
        }

        System.out.println("Невозможно выдать сумму");
        return false;
    }
}
