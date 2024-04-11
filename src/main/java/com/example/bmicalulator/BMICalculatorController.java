/*
    Name: Pranjal Prasanna Ekhande
    Date: 31 March 2024
    File Name: BMICalculatorController.java:
    Description: This Java class serves as the controller for the BMI Calculator application.
                The controller is responsible for initializing the UI components defined in the
                corresponding FXML file (BMICalculator.fxml) and implementing event handlers to respond to
                user actions.
*/
package com.example.bmicalulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class BMICalculatorController {
        @FXML
        private TextField weightField;
        @FXML
        private TextField feetCmField;
        @FXML
        private TextField inchesField;
        @FXML
        private Label heightLabel;
        @FXML
        private Label weightLabel;
        @FXML
        private Label calculatedBMI;
        @FXML
        private Label bmiCategory;
        @FXML
        private Button calculateButton;
        @FXML
        private ComboBox<String> unitComboBox;

        @FXML
        private void initialize() {
                // Set default value for unitComboBox
                unitComboBox.setValue("Metric (kg/cm)");
                // Updates UI labels
                updateLabels();
        }
        // Event handler for the unitComboBox
        @FXML
        private void onUnitChanged(ActionEvent event) {
                // Update UI labels
                updateLabels();
        }

        // Update UI labels based on the selected unit system
        private void updateLabels() {
                if (unitComboBox.getValue().equals("Imperial (lbs/ft/in)")) {
                        heightLabel.setText("Height:");
                        feetCmField.setPromptText("Feet");
                        feetCmField.setText("");

                        inchesField.setVisible(true);
                        inchesField.setPromptText("Inches");
                        inchesField.setText("");

                        weightLabel.setText("Weight (lbs):");
                        weightField.setPromptText("Pounds");
                        weightField.setText("");

                        calculatedBMI.setText("");
                        bmiCategory.setText("");

                } else {
                        heightLabel.setText("Height (cm):");
                        feetCmField.setPromptText("Centimeters");
                        feetCmField.setText("");

                        inchesField.setVisible(false);
                        inchesField.setPromptText("");
                        inchesField.setText("");

                        weightLabel.setText("Weight (kg):");
                        weightField.setPromptText("Kilograms");
                        weightField.setText("");

                        calculatedBMI.setText("");
                        bmiCategory.setText("");
                }
        }

        // Event handler for the calculate button
        @FXML
        private void calculateBMI(ActionEvent event) {
                try {
                        double height = 0.0;
                        double weight = Double.parseDouble(weightField.getText());

                        if (unitComboBox.getValue().equals("Imperial (lbs/ft/in)")) {
                                double feet = Double.parseDouble(feetCmField.getText());
                                double inches = Double.parseDouble(inchesField.getText());
                                height = feet * 12 + inches; // Convert feet and inches to inches
                                height *= 2.54; // Convert inches to centimeters
                                weight *= 0.453592; // Convert pounds to kilograms
                        } else {
                                height = Double.parseDouble(feetCmField.getText());
                        }

                        // Calculate BMI
                        double bmi = weight / ((height / 100) * (height / 100));

                        // Display BMI
                        calculatedBMI.setText("Your BMI is: " + String.format("%.2f", bmi));

                        // Determine BMI category
                        String category;
                        if (bmi < 18.5) {
                                category = "Underweight";
                        } else if (bmi < 24.9) {
                                category = "Normal weight";
                        } else if (bmi < 29.9) {
                                category = "Overweight";
                        } else {
                                category = "Obese";
                        }
                        bmiCategory.setText("Category: " + category);
                } catch (NumberFormatException e) {
                        calculatedBMI.setText("Invalid input. Please enter valid height and weight.");
                        bmiCategory.setText("");
                }
        }
}
