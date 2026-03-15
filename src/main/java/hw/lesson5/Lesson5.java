/**
 * Домашнее задание №5
 *
 * @author Nikita Shaternik
 * 15.03.2026
 */

package hw.lesson5;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

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
    public static VBox taskThree(TextArea logArea, Main main) {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);

        Label header = new Label("Задание 3");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label title = new Label("""
                               Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой.
                               Формат входных данных:
                               Программа получает на вход два числа n и m.
                               Формат выходных данных:
                               Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3 символа""");
        title.setWrapText(true);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setAlignment(Pos.CENTER);

        Button run = new Button("Выполнить");
        Button back = new Button("Назад");

        Label labelFirst = new Label("Введите число для строк:");
        TextField inputFirst = new TextField();
        inputFirst.setMaxWidth(200);

        Label labelSecond = new Label("Введите число столбцов:");
        TextField inputSecond = new TextField();
        inputSecond.setMaxWidth(200);

        Label underTitle = new Label("Для проверки введите числа и нажмите кнопку \"Выполнить\" ");
        underTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        run.setOnAction(e -> {

            try {
                int numberFirst = Integer.parseInt(inputFirst.getText());
                int numberSecond = Integer.parseInt(inputSecond.getText());

                logArea.appendText( "Создается массив из " + numberFirst + " строк и " + numberSecond + " столбцов\n");

                int numberForScore = 0;
                int[][] arrayThreeTask = new int[numberFirst][numberSecond];

                for (int i = 0; i < arrayThreeTask.length; i++) {
                    if (i % 2 == 0) { // слева направо
                        for (int j = 0; j < arrayThreeTask[i].length; j++) {
                            arrayThreeTask[i][j] = numberForScore++;
                        }
                    } else { // справа налево
                        for (int j = arrayThreeTask[i].length - 1; j >= 0; j--) {
                            arrayThreeTask[i][j] = numberForScore++;
                        }
                    }
                }
                for (int i = 0; i < arrayThreeTask.length; i++) {
                    for (int j = 0; j < arrayThreeTask[i].length; j++) {
                        logArea.appendText(String.format("%3d", arrayThreeTask[i][j]));
                    }
                    logArea.appendText("\n");
                }
            } catch (Exception ex) {
                logArea.appendText("Ошибка: нужно ввести число\n");
            }
        });

        back.setOnAction(e -> {
            main.backToMenu();
            logArea.clear();
        });

        box.getChildren().addAll(header, title, labelFirst, inputFirst, labelSecond, inputSecond,underTitle, run, back);
        return box;
    }
}
