package hw.lesson5;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * Домашнее задание №5
 *
 * @author Nikita Shaternik
 * 14.03.2026
 */

public class Lesson5 {

    /*Задача 1:
    1.1 Создать двумерный массив, заполнить его случайными числами.
    1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
    1.3 Найти сумму всех получившихся элементов и вывести в консоль. */

    public static VBox taskOne(TextArea logArea, Main main) {

        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);

        Label header = new Label("Задание 1");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label underTitle = new Label("Для проверки введите число и нажмите кнопку \"Выполнить\" ");
        underTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label title = new Label("""
                                Создать двумерный массив, заполнить его случайными числами.
                                Добавить к каждому значению число, которое пользователь будет вводить с консоли.
                                Найти сумму всех получившихся элементов и вывести в консоль.
                                """);
        title.setWrapText(true);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setAlignment(Pos.CENTER);

        Button run = new Button("Выполнить");
        Button back = new Button("Назад");

        Label label = new Label("Введите число:");
        TextField input = new TextField();
        input.setMaxWidth(200);

        run.setOnAction(e -> {
            logArea.appendText("Сформирован массив.\n");
            int[][] arrayOneTask = new int[3][3];
            int sum = 0;

            //перебираем массив для вывода
            for (int i = 0; i < arrayOneTask.length; i++) {
                for (int j = 0; j < arrayOneTask[i].length; j++) {

                    arrayOneTask[i][j] = (int)(Math.random() * 10);

                    logArea.appendText(String.format("%3d", arrayOneTask[i][j]));
                }
                logArea.appendText("\n");
            }

            //назначаем число, которое плюсуется и собираем сумму
            logArea.appendText("Введите число: ");

            try {
                int number = Integer.parseInt(input.getText());

                logArea.appendText( number + "\n");

                for (int i = 0; i < arrayOneTask.length; i++) {
                    for (int j = 0; j < arrayOneTask[i].length; j++) {

                        arrayOneTask[i][j] +=number;
                        sum += arrayOneTask[i][j];

                        logArea.appendText(String.format("%3d", arrayOneTask[i][j]));
                    }
                    logArea.appendText("\n");
                }
                logArea.appendText("Сумма = " + sum + "\n\n");

            } catch (Exception ex) {
                logArea.appendText("Ошибка: нужно ввести число\n");
            }
        });

        back.setOnAction(e -> main.backToMenu());

        box.getChildren().addAll(header, title, underTitle, label, input, run, back);

        return box;
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
    public static VBox taskTwo(TextArea logArea, Main main) {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);

        Label header = new Label("Задание 2");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label title = new Label("""
                    Создать программу для раскраски шахматной доски с помощью цикла. Создать
                    двумерный массив String 8х8. С помощью циклов задать элементам массива значения
                    B(Black) или W(White).""");
        title.setWrapText(true);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setAlignment(Pos.CENTER);

        Button run = new Button("Выполнить");
        Button back = new Button("Назад");

        String[][] arrayTwoTask = new String[8][8];

        run.setOnAction(e -> {
            logArea.appendText("Результат задания:\n");
            //перебираем массив и назначаем цвет
            for (int i = 0; i < arrayTwoTask.length; i++) {
                for (int j = 0; j < arrayTwoTask[i].length; j++) {

                    if ((i+j) % 2 == 0){
                        arrayTwoTask[i][j] = "W";
                    } else {
                        arrayTwoTask[i][j] = "B";
                    }

                    logArea.appendText(String.format("%2s", arrayTwoTask[i][j]));
                }
                logArea.appendText("\n");
            }
        });

        back.setOnAction(e -> {
            main.backToMenu();
            logArea.clear();
        });

        box.getChildren().addAll(header, title, run, back);

        return box;
    }
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
