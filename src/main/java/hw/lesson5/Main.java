package hw.lesson5;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane root;
    private TextArea logArea;

    @Override
    public void start(Stage stage) {
        root = new BorderPane();

        Label title = new Label("Привет, Томаш!");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(20));
        root.setTop(title);

        logArea = new TextArea();
        VBox bottomBox = new VBox(logArea);
        logArea.setEditable(false);
        bottomBox.setPadding(new Insets(10));
        logArea.setStyle("""
                    -fx-font-family: Consolas;
                    -fx-font-size: 13px; 
                     """);
        root.setBottom(bottomBox);

        showMainMenu();

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Интерфейс для домашнего задания");
        stage.setScene(scene);
        stage.show();
    }

    private void showMainMenu() {

        Lesson5 tasker = new Lesson5();
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20));

        Button task1 = new Button("Задание 1");
        Button task2 = new Button("Задание 2");
        Button task3 = new Button("Задание 3");
        Button exit = new Button("Выход");

        buttons.getChildren().addAll(task1, task2, task3, exit);

        root.setCenter(buttons);

        task1.setOnAction(e -> {
            logArea.clear();
            logArea.appendText("Открыто задание 1\n");
            root.setCenter(tasker.taskOne(logArea, this));
        });

        task2.setOnAction(e -> {
            logArea.clear();
            logArea.appendText("Открыто задание 2\n");
            root.setCenter(tasker.taskTwo(logArea, this));
        });
        task3.setOnAction(e -> logArea.appendText("Задание 3 пока не сделано\n"));

        exit.setOnAction(e -> {
            logArea.appendText("Выход...\n");
            System.exit(0);
        });
    }

    public void backToMenu() {
        showMainMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}