package com.example.finallababeer;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Locale;

public class ClassfyChar extends Thread {
    private String name;
    private Label outputLabel;

    public ClassfyChar(String name, Label outputLabel) {
        this.name = name;
        this.outputLabel = outputLabel;

    }

    @Override
    public void run() {
        Platform.runLater(() -> {

            char[] arrayName = name.toUpperCase().toCharArray();
            char seleChar = arrayName[1];


                if (seleChar >= 'A' && seleChar <= 'I') {
                    outputLabel.setText("second char: " +seleChar + " group(A,B,C,D,E,F,G,H,I)");
                }
                else if (seleChar >= 'J' && seleChar <= 'R'){
                    outputLabel.setText("second char: " +seleChar + " group(J,K,L,M,N,O,P,Q,R)");

            }
                else if (seleChar >= 'S' && seleChar <= 'Z'){
                    outputLabel.setText("second char: " +seleChar + " group(S,T,U,V,W,X,Y,Z)");

                }


        });
    }

}