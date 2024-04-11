/*
    Name: Pranjal Prasanna Ekhande
    Date: 31 March 2024
    File Name: BMICalculatorController.java:
    Description: This Java class is the main entry point for the BMI Calculator application.
                It initializes the JavaFX environment, loads the FXML file (BMICalculator.fxml)
                to define the user interface, and sets up the primary stage for displaying the UI.

*/

package com.example.bmicalulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BMICalculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 420);


        stage.setTitle("BMI Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}