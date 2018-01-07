/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaFX.DialogsAndAlerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

/**
 *
 * @author Ramin
 */
public class ChoiceDialogEx extends Application {
    //DIQQET her java classi ayrica Shift + F6 duymelerinin kombinasiyasi ile ishe salin

    @Override
    public void start(Stage primaryStage) {
        List<String> choices = new ArrayList<>();
        choices.add("Test Choise 1");
        choices.add("Test Choise 2");
        choices.add("Test Choise 3");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Secim edin Zehmet olmasa", choices);
        dialog.setTitle("The Title");
        dialog.setHeaderText("The Header");
        dialog.setContentText("Secin Zehmet olmasa:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get());

        } else {
            System.err.println("Null");
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(letter -> System.out.println("Your choice: " + letter));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
