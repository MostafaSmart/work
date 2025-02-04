package com.example.finallababeer;

import javafx.application.Platform;
import javafx.scene.control.Label;

class NameThred extends Thread {
    private String name;
    private Label outputLabel;

    public NameThred(String name, Label outputLabel) {
        this.name = name;
        this.outputLabel = outputLabel;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            String low = name.toLowerCase();
            if(name.equalsIgnoreCase("Abeer")){
                outputLabel.setText(name);

            }
            else{
                outputLabel.setText("the name must be abeer");

            }

        });
    }
}
