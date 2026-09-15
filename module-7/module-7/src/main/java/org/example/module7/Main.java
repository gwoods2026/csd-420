//Garrett Woods Module 7

package org.example.module7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        HBox pane = new HBox(20);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-padding: 40px; -fx-background-color: #f4f4f4;");

        //Creates Circles
        Circle circle1 = new Circle(50);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);


        //assigns the class and IDs to the circles
        circle1.getStyleClass().add("white-circle");
        Rectangle rect = new Rectangle(120, 500);
        rect.getStyleClass().add("border-rectangle");

        circle2.getStyleClass().add("white-circle");

        circle3.setId("red-circle");

        circle4.setId("green-circle");


        //stacks the rectangle on the first circle
        StackPane shapeGroup = new StackPane();
        shapeGroup.getChildren().addAll(rect, circle1);

        //adds shapes to the scene
        pane.getChildren().addAll(shapeGroup, circle2, circle3, circle4);

        //creates the scene
        Scene scene = new Scene(pane);

        //gets style from style sheet
        String cssPath = getClass().getResource("mystyle.css").toExternalForm();
        scene.getStylesheets().add(cssPath);

        //runs built in tests
        runTests(cssPath, circle1, circle2, circle3, circle4);

        //sets the stage
        primaryStage.setTitle("Module 7");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runTests(String cssPath, Circle c1, Circle c2, Circle c3, Circle c4) {

        //checks to see if able to find the style sheet and shows results
        if (cssPath != null && !cssPath.isEmpty()) {
            System.out.println("Found external style sheet");
        } else {
            System.out.println("Could not find style sheet. Check name and location of file");
        }
        //checks to see if able to find the white-circle class and shows results
        if (c1.getStyleClass().contains("white-circle") && c2.getStyleClass().contains("white-circle")) {
            System.out.println("Successfully applied white-circle class");
        } else {
            System.out.println("Unable to apply white-circle class");
        }

        //checks to see if able to find the red-circle ID and shows results
        if ("red-circle".equals(c3.getId())) {
            System.out.println("Successfully applied red-circle ID");
        } else {
            System.out.println("Unable to apply red-circle ID");
        }

        //checks to see if able to find the green-circle ID and shows results
        if ("green-circle".equals(c4.getId())) {
            System.out.println("Successfully applied green-circle ID");
        } else {
            System.out.println("Unable to apply green-circle ID");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}