package com.example.sudoku;

import com.example.sudoku.view.HomeView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("prueba git");
        HomeView.getInstance();
    }

    public static void main(String[] args) {
        launch();
    }
}