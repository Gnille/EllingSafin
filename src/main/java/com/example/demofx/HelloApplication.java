package com.example.demofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Insets;  // Import for Insets

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // Create the main structure with BorderPane
        BorderPane root = new BorderPane();

        // Circle image import
        InputStream circleImage = new FileInputStream("images/Circle.png");
        Image circleImageImport = new Image(circleImage);
        ImageView imageViewCircle = new ImageView(circleImageImport);
        imageViewCircle.setFitWidth(35);
        imageViewCircle.setFitHeight(35);

        // Rectangle image import
        InputStream rectangleImage = new FileInputStream("images/Rectangle.png");
        Image rectangleImageImport = new Image(rectangleImage);
        ImageView imageViewRectangle = new ImageView(rectangleImageImport);
        imageViewRectangle.setFitWidth(35);
        imageViewRectangle.setFitHeight(35);

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();

        // file
        Menu fileMenu = new Menu("File");
        MenuItem NewItem = new MenuItem("New");
        MenuItem OpenItem = new MenuItem("Open");
        MenuItem SaveItem = new MenuItem("Save");
        MenuItem SaveAsItem = new MenuItem("Save As");
        fileMenu.getItems().addAll(NewItem, OpenItem, SaveItem, SaveAsItem);

        // viktige funksjonenene
        Menu shapesMenu = new Menu("Shapes");
        MenuItem circleItem = new MenuItem("Circle");
        circleItem.setGraphic(imageViewCircle);
        MenuItem rectangleItem = new MenuItem("Rectangle");
        rectangleItem.setGraphic(imageViewRectangle);
        shapesMenu.getItems().addAll(circleItem, rectangleItem);

        // Add Colors Menu
        Menu colorMenu = new Menu("Colors");
        MenuItem lineColorItem = new MenuItem("Line Color");
        MenuItem fillColorItem = new MenuItem("Fill Color");
        colorMenu.getItems().addAll(lineColorItem, fillColorItem);

        // Add all menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, shapesMenu, colorMenu);

        // Create an HBox container for the MenuBar to add padding and force height
        HBox menuBarContainer = new HBox();
        menuBarContainer.setPadding(new Insets(10));  // Adds padding around the MenuBar
        menuBarContainer.getChildren().add(menuBar);
        menuBarContainer.setPrefHeight(80);  // Adjust the height of the HBox to make the MenuBar area taller

        // Create drawing area (Pane)
        Pane drawingPane = new Pane();
        drawingPane.setStyle("-fx-background-color: white;");

        // Place the components in the BorderPane
        root.setTop(menuBarContainer);  // HBox containing MenuBar at the top
        root.setCenter(drawingPane);    // Drawing Pane in the center

        // Set up the scene
        Scene scene = new Scene(root, 1000, 600);  // Define the scene size
        stage.setTitle("Elling og Safin Paint");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
