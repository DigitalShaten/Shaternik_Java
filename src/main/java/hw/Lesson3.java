package hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Домашнее задание №3
 * @author Nikita Shaternik
 * 04.03.2026
 */

public class Lesson3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tasker tasker = new Tasker();

        while (true) {
            System.out.println("\n1 - Добавить задачу");
            System.out.println("2 - Показать все задачи");
            System.out.println("3 - Удалить задачу");
            System.out.println("4 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> tasker.addTaskName();
                case 2 -> tasker.showTasks();
                case 3 -> tasker.removeTask();
                case 4 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный пункт меню");
            }
        }
    }
}

class Tasker {

    private ArrayList<String> toDo = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //Создам мердж-конфликт за счет смены нейма метода
    public void addTaskName() {
        System.out.println("Введите задачу:");
        String task = scanner.nextLine();

        if (task.isBlank()) {
            System.out.println("Пустую задачу добавить нельзя!");
            return;
        }

        toDo.add(task);
        System.out.println("Задача добавлена!");
    }

    public void showTasks() {
        if (toDo.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        for (int i = 0; i < toDo.size(); i++) {
            System.out.println((i + 1) + ". " + toDo.get(i));
        }
    }

    public void removeTask() {
        if (toDo.isEmpty()) {
            System.out.println("Удалять нечего.");
            return;
        }

        showTasks();
        System.out.println("Введите номер задачи для удаления:");

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > toDo.size()) {
            System.out.println("Неверный номер задачи!");
            return;
        }

        toDo.remove(index - 1);
        System.out.println("Задача удалена.");
    }
}

