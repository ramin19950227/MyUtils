/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlsfxautocompletewithobjects;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Ramin
 */
public class TestApp extends Application {

    TextField tf = new TextField();

    @Override
    public void start(Stage primaryStage) {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Ramin", 21));
        humanList.add(new Human("Elvin", 30));
        humanList.add(new Human("Test", 99));

        //bunlarin hamiisi initialize metodunda yada Constructorda yaziriq
        //bu auto completeni elan ve teyin edilmesidir
        // TextField ve Listimizi veririk
        AutoCompletionBinding<Human> bindAutoCompletion = TextFields.bindAutoCompletion(tf, humanList);
        // bu metod secilen obyekti qaytarir getCompletion() Listde olan obyekti qaytarir
        bindAutoCompletion.setOnAutoCompleted(
                e -> System.out.println(e.getCompletion().getAge()));
//
//        bindAutoCompletion.addEventHandler(javafx.event.EventType.ROOT, (event) -> {
//            event.
//        });

//        AutoCompletionBinding<Human> autoCompletionBinding
//                = TextFields.bindAutoCompletion(tf, humanList,
//                        new StringConverter<Human>() {
//                    public Human fromString(String s) {
//                        throw new UnsupportedOperationException();
//                    }
//
//                    public String toString(Human t) {
//                        return t.toString();
//                    }
//                }
//                );
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        root.getChildren().add(tf);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
