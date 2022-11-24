package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Circle circle;
    int clicked = 0;
    public Label counter;
    Timeline animation;

    public void clickEvent(ActionEvent actionEvent) {
        clicked++;
        counter.setText(String.valueOf(clicked));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        counter.setText(String.valueOf(clicked));
        animation = new Timeline(new KeyFrame(
                Duration.millis(1000),
                e -> {
                    changeColor();
                    System.out.println("Color change");
                }
        ));
        animation.setCycleCount(Animation.INDEFINITE);
    }

    public void startAnimation(ActionEvent actionEvent) {
        animation.play();
    }

    byte currentColor = -1;
    private void changeColor() {
        currentColor++;
        switch (currentColor) {
            case 0 -> circle.setFill(Paint.valueOf("RED"));
            case 1 -> circle.setFill(Paint.valueOf("GREEN"));
            case 2 -> circle.setFill(Paint.valueOf("BLUE"));
            default -> currentColor = -1;
        }
    }
}