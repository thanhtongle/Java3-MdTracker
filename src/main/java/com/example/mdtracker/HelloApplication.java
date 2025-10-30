package com.example.mdtracker;

import com.example.mdtracker.database.Database;
import com.example.mdtracker.tabs.AddItemTab;
import com.example.mdtracker.tabs.RemoveItemTab;
import com.example.mdtracker.tabs.StatisticsItemTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        // Build a Menu bar
        MenuBar menuBar = new MenuBar();
        // Build Menus
        Menu file = new Menu("File");
        Menu credits = new Menu("Credits");

        // Build Menu Items
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            System.exit(0);
        });
        // Add the menu items to the menu
        file.getItems().addAll(exit);
        // Add the menus to the bar
        menuBar.getMenus().addAll(file, credits);
        root.setTop(menuBar);

        // Create a tabpane
        TabPane tabPane = new TabPane();
        // Create tabs
        AddItemTab addItemTab = new AddItemTab();
        RemoveItemTab removeItemTab = new RemoveItemTab();
        StatisticsItemTab statisticsItemTab = new StatisticsItemTab();
        Database dbc = Database.getInstance();
        // Display them
        tabPane.getTabs().addAll(addItemTab, removeItemTab, statisticsItemTab);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}