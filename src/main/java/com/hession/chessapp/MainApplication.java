package com.hession.chessapp;

import com.hession.chessapp.board.ChessBoard;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Chess Game");
        stage.setHeight(800);
        stage.setWidth(1000);
        ChessBoard chessBoard = new ChessBoard();
        Group board = new Group(chessBoard.getBoard());
        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}