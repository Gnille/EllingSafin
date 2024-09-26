package com.example.demofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.Group;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage)  throws FileNotFoundException {
        // Opprett hovedstrukturen med BorderPane
        BorderPane root = new BorderPane();

        // Opprett menylinje (MenuBar)
        InputStream circleImage = new FileInputStream("C:\\Users\\Elling\\Documents\\OBJ1000\\JavaObligHøst24\\images\\Circle.png");
        Image circleImageImport = new Image(circleImage);
        ImageView imageViewCircle = new ImageView(circleImageImport);

        MenuBar menuBar = new MenuBar();
        Menu shapesMenu = new Menu("Shapes");
        MenuItem circleItem = new MenuItem("Circle");
        circleItem.setGraphic(imageViewCircle);
        MenuItem rectangleItem = new MenuItem("Rectangle");
        shapesMenu.getItems().addAll(circleItem, rectangleItem);

        Menu colorMenu = new Menu("Colors");
        MenuItem lineColorItem = new MenuItem("Line Color");
        MenuItem fillColorItem = new MenuItem("Fill Color");
        colorMenu.getItems().addAll(lineColorItem, fillColorItem);

        menuBar.getMenus().addAll(shapesMenu, colorMenu);

        // Opprett tegneflate (Pane)
        Pane drawingPane = new Pane();
        drawingPane.setStyle("-fx-background-color: white;");

        /*// Informasjons- og kontrollpanel til høyre (for nå tom)
        VBox infoPanel = new VBox();
        infoPanel.setStyle("-fx-border-color: black; -fx-padding: 10;");
        Label infoLabel = new Label("Information and Controls");
        infoPanel.getChildren().add(infoLabel);*/

        // Plasser komponentene i BorderPane
        root.setTop(menuBar);          // MenuBar på toppen
        root.setCenter(drawingPane);   // Tegneflaten i sentrum
        // root.setRight(infoPanel);      // Info- og kontrollpanel på høyre side

        // Sett opp scenen
        Group root1 = new Group(imageViewCircle);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Elling og Safin Paint");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
