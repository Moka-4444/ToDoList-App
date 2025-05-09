package com.example.demo1;// ---------------------
// Project 3: To-Do List (Standalone JavaFX App)
// ---------------------

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ToDoListApp extends Application {
    private ListView<String> todoListView;
    private TextField taskInput;
    private final ArrayList<String> tasks = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        VBox root = createTodoListUI();

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }

    private VBox createTodoListUI() {
        todoListView = new ListView<>();
        taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");

        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> addTask());

        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(e -> deleteSelectedTask());

        HBox buttons = new HBox(10, addButton, deleteButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, taskInput, buttons, todoListView);
        layout.setPadding(new Insets(20));
        return layout;
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            todoListView.getItems().add(task);
            taskInput.clear();
        }
    }

    private void deleteSelectedTask() {
        String selected = todoListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tasks.remove(selected);
            todoListView.getItems().remove(selected);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
