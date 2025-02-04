package com.example.finallababeer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FinalLab extends Application {
    int flag = 0;
    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        Label nameLabel = new Label("Enter Name:");
        TextField nameField = new TextField();
        Button startButton = new Button("Check Name");
        Label outputLabel = new Label();



        startButton.setOnAction(event -> {
            String name;
            try {
                name = nameField.getText();
                NameThred numberThread = new NameThred(name, outputLabel);
                ClassfyChar classfyChar = new ClassfyChar(name,outputLabel);

                if(flag == 0){
                    numberThread.start();
                    flag = 1;
                    numberThread.join();

                }
                else{
                    classfyChar.start();
                    classfyChar.join();
                    flag = 1;
                }

            } catch (NumberFormatException e) {
                outputLabel.setText("Invalid input. Please enter an String value.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });


        VBox layout = new VBox(10, nameLabel, nameField, startButton, outputLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(layout, 350, 250);
        primaryStage.setTitle("Final Lab");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}