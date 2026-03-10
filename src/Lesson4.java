import java.util.Arrays;
import java.util.Scanner;

/**
 * Домашнее задание №3
 * @author Nikita Shaternik
 * 10.03.2026
 */

public class Lesson4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static String message;
    private static int numberOfArray = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("4 - Задача 4");
            System.out.println("5 - Задача 5");
            System.out.println("6 - Задача 6");
            System.out.println("7 - Задача 7");
            System.out.println("0 - Выход");
            System.out.println("Введите номер задачи: ");

            if (scanner.hasNextInt()) {
                int choose = scanner.nextInt();

                switch (choose) {
                    case 1 -> taskOne();
                    case 2 -> taskTwo();
                    case 3 -> taskThree();
                    case 4 -> taskFour();
                    case 5 -> taskFive();
                    case 6 -> taskSix();
                    case 7 -> taskSeven();
                    case 0 -> {
                        printDash("Выхожу...");
                        return;
                    }
                    default -> {
                        printDash("Нет такого выбора...Давай еще раз...");
                    }
                }
            } else {
                System.out.println("Введите число: ");
                scanner.next();
            }
        }
    }

    /*Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер массива (просто целое число).
    После того, как размер массива задан, заполнить его одним из двух способов: используя Math.random(),
    или каждый элемент массива вводится пользователем вручную. Попробовать оба варианта.
    После заполнения массива данными, решить для него следующие задачи:*/

    public static void taskOne () {
        /*Задача 1:
        Пройти по массиву, вывести все элементы в прямом и в обратном порядке.*/
        System.out.println("Задача 1: Пройти по массиву, вывести все элементы в прямом и в обратном порядке.");
        System.out.println("Задайте размер массива.");

        int numberOfArray = scannerNumber();
        int[] arrayTaskOne = arrayCreate(numberOfArray);

        System.out.println("Сначала в одном порядке");
        for (int i = 0; i < arrayTaskOne.length; i++) {
            System.out.print(arrayTaskOne[i]);
            if (i < arrayTaskOne.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\nТеперь в другом порядке:");
        for (int i= arrayTaskOne.length-1; i >= 0; i--) {
            System.out.print(arrayTaskOne[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("\nЗадача выполнена!");
        printDash("Продолжим?");
    }


    public static void taskTwo () {
        /*Задача 2:
        Найти минимальный-максимальный элементы и вывести в консоль*/
        System.out.println("Задача 2: Найти минимальный-максимальный элемент и вывести в консоль.");
        System.out.println("Задайте размер массива.");

        int numberOfArray = scannerNumber();
        int[] arrayTaskTwo = arrayCreate(numberOfArray);

        System.out.println("Сформирован массив: " + Arrays.toString(arrayTaskTwo));
        Arrays.sort(arrayTaskTwo);
        System.out.println("Минимальное значение: " + arrayTaskTwo[0]);
        System.out.println("Максимальное значение: " + arrayTaskTwo[numberOfArray-1]);

        /*
        Болеее длинное решение
        int maxNumber = arrayTaskTwo[0];
        int minNumber = arrayTaskTwo[0];

        for(int number : arrayTaskTwo) {
            if (number > maxNumber) maxNumber = number; // Ищем максимальное значение
            if (number < minNumber) minNumber = number; // Ищем минимальное значение
        }

        System.out.println("\nМаксимальный элемент: " + maxNumber);
        System.out.println("Минимальный элемент: " + minNumber);
         */

        printDash("Продолжим?");
    }

    public static void taskThree () {
        /*Задача 3:
        Найти индексы минимального и максимального элементов и вывести в консоль.*/

        System.out.println("Задача 3: Найти индекс минимального и максимального элемента и вывести в консоль.");
        System.out.println("Задайте размер массива.");

        int numberOfArray = scannerNumber();
        int[] arrayTaskThree = arrayCreate(numberOfArray);

        int maxIndex = 0;
        int minIndex = 0;

        System.out.println("Сформирован массив: " + Arrays.toString(arrayTaskThree));
        for (int i = 0; i < arrayTaskThree.length; i++) {
            if (arrayTaskThree[i] > arrayTaskThree[maxIndex]) {
                maxIndex=i;
            }
            if (arrayTaskThree[i] < arrayTaskThree[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("\nИндекс минимального элемента: " + minIndex);
        System.out.println("Индекс максимального элемента: " + maxIndex);
        printDash("Продолжим?");
    }
    public static void taskFour () {
        /*Задача 4:
        Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести сообщение, что их нет. */
        System.out.println("Задача 4: Найти и вывести количество нулевых элементов.");
        System.out.println("Задайте размер массива. Введите целое число: ");

        short zeroArrayCapacity = 0;
        int numberOfArray = scannerNumber();
        int[] arrayTaskFour = new int[numberOfArray];

        System.out.println("Задайте значения для массива.");
        for (int i = 0; i < numberOfArray; i++) {
            System.out.println("Введите элемент " + (i+1) + ": ");
            arrayTaskFour[i] = scanner.nextInt();
        }

        for (int num : arrayTaskFour) {
            if (num == 0) zeroArrayCapacity++;
        }

        if (zeroArrayCapacity == 0) {
            System.out.println("В массиве нет нулевых элементов.");
        } else {
            System.out.println("Количество нулевых элементов составляет: " + zeroArrayCapacity);
        }

        printDash("Продолжим?");

    }
    public static void taskFive () {
        /*Задача 5:
        Пройти по массиву и поменять местами элементы первый и последний, второй и
        предпоследний и т.д.*/
        System.out.println("Задача 5: Пройти по массиву и поменять местами элементы первый и последний, второй и предпоследний и т.д.");
        System.out.println("Задайте размер массива.");

        int numberOfArray = scannerNumber();
        int[] arrayTaskFive = arrayCreate(numberOfArray);

        System.out.println("Сформирован массив: " + Arrays.toString(arrayTaskFive));

        for (int i = 0; i < numberOfArray / 2; i++) {
            int temp = arrayTaskFive[i];
            arrayTaskFive[i] = arrayTaskFive[numberOfArray - 1 - i];
            arrayTaskFive[numberOfArray - 1 - i] = temp;
        }
        System.out.println("Поменяли местами массив: " + Arrays.toString(arrayTaskFive));
        printDash("Продолжим?");
    }

    public static void taskSix () {
        /*Задача 6:
        Проверить, является ли массив возрастающей последовательностью (каждое следующее
        число больше предыдущего).*/

        System.out.println("Задача 5: Пройти по массиву и поменять местами элементы первый и последний, второй и предпоследний и т.д.");
        System.out.println("Задайте размер массива.");
        boolean checkUpperArray = true;
        int numberOfArray = scannerNumber();
        int[] arrayTaskSix = new int[numberOfArray];

        System.out.println("Задайте значения для массива.");
        for (int i = 0; i < numberOfArray; i++) {
            System.out.println("Введите элемент " + (i+1) + ": ");
            arrayTaskSix[i] = scanner.nextInt();
        }

        System.out.println("Сформирован массив: " + Arrays.toString(arrayTaskSix));
        for (int i = 1; i < arrayTaskSix.length; i++) {
            if (arrayTaskSix[i] <= arrayTaskSix[i - 1]) {
                checkUpperArray = false;
            }
        }

        if (checkUpperArray) {
            System.out.println("Массив имеет возрастающую последовательность");
        } else {
            System.out.println("Массив не имеет возрастающую последовательность :(");
        }
        printDash("Продолжим?");

    }

    public static void taskSeven () {
        /* Задача *:
        Имеется массив из неотрицательных чисел(любой). Представьте что массив
        представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
        добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
        содержит нуля в начале, кроме самого числа 0.
        Пример:
        Input: [1,4,0,5,6,3]
        Output: [1,4,0,5,6,4]
        Input: [9,9,9]
        Output: [1,0,0,0] */

        System.out.println("Задача 7: Задача добавить единицу к этому “числу” и на выходе получить исправленный массив.");
        System.out.println("Задайте размер массива.");

        int numberOfArray = scannerNumber();
        int[] arrayTaskSeven = new int[numberOfArray];

        System.out.println("Задайте значения для массива.");
        for (int i = 0; i < numberOfArray; i++) {
            System.out.println("Введите элемент " + (i+1) + ": ");
            arrayTaskSeven[i] = scanner.nextInt();
        }

        System.out.println("Сформирован массив: " + Arrays.toString(arrayTaskSeven));

        for (int i = arrayTaskSeven.length - 1; i >= 0; i --) {
            if (arrayTaskSeven[i] < 9) {
                arrayTaskSeven[i]++;
                System.out.println("Сформирован новый массив: " + Arrays.toString(arrayTaskSeven));
                return;
            }
            arrayTaskSeven[i] = 0;
        }
        int[] newArrayTaskSeven = new int[arrayTaskSeven.length+1];
        newArrayTaskSeven[0] = 1;

        System.out.println("Сформирован новый массив: " + Arrays.toString(newArrayTaskSeven));
    }

    /**
     *
     * @printDash метод LookAndFeel
     */
    public static void printDash(String message){
        System.out.println("----------------------------------------");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }

    /**
     *
     * @arrayCreate метод, который инициализирует и подготавливает массив
     */
    public static int[] arrayCreate (int numberScanner){
        int[] arrayForTask = new int[numberScanner];

        for (int i = 0; i < numberScanner; i++) {
            arrayForTask[i] = (int)(Math.random()*100)+1;
        }
        return arrayForTask;
    }

    /**
     *
     * @scannerNumber метод, который принимает ввод от пользователя и проверяет на целое положительное число
     */
    public static int scannerNumber() {
        int numberScanner;

        while (true) {
            System.out.println("Введите целое число:");

            if (scanner.hasNextInt()) {
                numberScanner = scanner.nextInt();

                if (numberScanner > 0) {
                    return numberScanner;
                } else {
                    System.out.println("Число должно быть больше 0.");
                }
            } else {
                System.out.println("Это не число!");
                scanner.next();
            }
        }
    }
}

