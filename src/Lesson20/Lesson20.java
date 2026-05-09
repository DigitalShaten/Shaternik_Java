package Lesson20;

import Lesson20.taskThree.Consumer;
import Lesson20.taskThree.Producer;
import Lesson20.taskThree.Store;
import Lesson20.thread.ThreadTaskOne;
import Lesson20.thread.ThreadTaskTwo;

import java.util.Scanner;

/**
 * Домашнее задание №20
 *
 * @author Nikita Shaternik
 * 09.05.2026
 */

public class Lesson20 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException  {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arrayOfNumber = new int[size];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            System.out.print("Элемент [" + i + "]: ");
            arrayOfNumber[i] = scanner.nextInt();
        }
        /*Задача 1:
        Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
        потока. Первый поток находит максимум в массиве, второй —Прове минимум. Результаты
        вычислений возвращаются в метод main(). */
        System.out.println("Задача 1: минимальное и максимальное значение массива");

        ThreadTaskOne threadMin = new ThreadTaskOne(arrayOfNumber, true);
        ThreadTaskOne threadMax = new ThreadTaskOne(arrayOfNumber, false);

        threadMin.start();
        threadMax.start();

        threadMin.join();
        threadMax.join();

        /*Задача 2:
        Сортировка массива цифр в нескольких потоках различными алгоритмами:
         сортировка вставками;
         сортировка выбором;
         сортировка пузырьком.
        Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
        результат отсортированных массивов в консоль. */

        Thread threadInseption = new Thread(new ThreadTaskTwo(arrayOfNumber.clone(), "INSERTION"));
        Thread threadSelection = new Thread(new ThreadTaskTwo(arrayOfNumber.clone(), "SELECTION"));
        Thread threadBuble = new Thread(new ThreadTaskTwo(arrayOfNumber.clone(), "BUBBLE"));

        threadInseption.start();
        threadSelection.start();
        threadBuble.start();

        threadInseption.join();
        threadSelection.join();
        threadBuble.join();

        /*Задача *:
        Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так чтобы
        производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
        не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
        может находиться не более 3 товаров. */
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        producer.start();
        consumer.start();
    }
}
