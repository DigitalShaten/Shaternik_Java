package hw.lesson5;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Домашнее задание №5
 *
 * @author Nikita Shaternik
 * 11.03.2026
 */

public class Lesson5 {
    private static Scanner scanner = new Scanner(System.in);

    public static void showTaskScene(Stage stage, String taskTitle, VBox taskContent) {
        //Повтор layout
        BorderPane root = new BorderPane();

        // Настройки для верхней фразы
        Label title = new Label("Привет, Томаш!");
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(20, 0, 20, 0));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        if (taskContent !=null) {
            root.setCenter(taskContent);
        }

        //Окно логов
        TextArea logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(150);
        logArea.setStyle("-fx-font-family: Consolas; -fx-font-size: 12px;");
        root.setBottom(logArea);

        // Окно
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
    }

    /*Задача 1:
    1.1 Создать двумерный массив, заполнить его случайными числами.
    1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
    1.3 Найти сумму всех получившихся элементов и вывести в консоль. */
    public static VBox showTaskOne(TextArea logArea) {

        VBox taskContent = new VBox(15);
        taskContent.setAlignment(Pos.CENTER);
        taskContent.setPadding(new Insets(20));


        return taskContent;
    }




    /*Задача 2:
    Создать программу для раскраски шахматной доски с помощью цикла. Создать
    двумерный массив String 8х8. С помощью циклов задать элементам массива значения
    B(Black) или W(White). При выводе результат работы программы должен быть
    следующим:
    W B W B W B W B
    B W B W B W B W
    W B W B W B W B
    B W B W B W B W
    W B W B W B W B
    B W B W B W B W
    W B W B W B W B
    B W B W B W B W*/
//    public static void taskTwo() {
//
//    }

    /*Задача *:
    Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).
    Формат входных данных:
    Программа получает на вход два числа n и m.
    Формат выходных данных:
    Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3
    символа */
//    public static void taskThree() {
//
//    }
}
