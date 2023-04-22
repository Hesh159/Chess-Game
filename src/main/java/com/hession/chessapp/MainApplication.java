package com.hession.chessapp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Chess Game");
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}