package hw.lesson5;

import javafx.application.Application;
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

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        Lesson5 homework = new Lesson5();

        // Настройки для верхней фразы
        Label title = new Label("Привет, Томаш!");
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(20, 0, 20, 0));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        // Окно
        Scene scene = new Scene(root, 800, 600);

        //Окно логов
        TextArea logArea = new TextArea();
        logArea.setEditable(false); // запрещаем писать в логах
        logArea.setPrefHeight(150);
        logArea.setStyle("-fx-font-family: Consolas; -fx-font-size: 12px;"); // нагенерил красоты чуток
        root.setBottom(logArea);

        //Кнопки
        HBox buttons = new HBox(10);

        Button taskOneBut = new Button("Задание 1");
        Button taskTwoBut = new Button("Задание 2");
        Button taskThreeBut = new Button("Задание 3");
        Button exit = new Button("Выход");
        buttons.getChildren().addAll(taskOneBut, taskTwoBut, taskThreeBut, exit);
        buttons.setAlignment(Pos.CENTER);
        //Стили кнопочек
        buttons.setStyle("""
                    -fx-background-color: #3498db;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                """);
        buttons.setPadding(new Insets(20));

        root.setCenter(buttons);

        VBox taskContent = Lesson5.showTaskOne(logArea);

        // Добавляем обработчик для кнопок
        taskOneBut.setOnAction(e -> {
//            logArea.appendText("Нажали Задание 1!\n");
//            homework.showTaskOne(stage, "Задание 1", taskContent);
        });
        taskTwoBut.setOnAction(e -> logArea.appendText("Нажали Задание 2!\n"));
        taskThreeBut.setOnAction(e -> logArea.appendText("Нажали Задание 3!\n"));
        exit.setOnAction(e -> {
            logArea.appendText("Выход...\n");
            stage.close();
        });


        stage.setTitle("Интерфейс для домашнего задания");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}