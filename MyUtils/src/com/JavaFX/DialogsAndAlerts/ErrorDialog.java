/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaFX.DialogsAndAlerts;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 *
 * @author Ramin
 */
public class ErrorDialog extends Application {
    //DIQQET her java classi ayrica Shift + F6 duymelerinin kombinasiyasi ile ishe salin

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        alert.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
