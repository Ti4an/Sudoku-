package com.example.sudoku;

import com.example.sudoku.view.HomeView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * @author Sebastian Bucheli Miranda
 * @version 1.0
 * Clase principal que inicia la aplicación Sudoku.
 * Extiende Application de JavaFX.
 */
public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HomeView.getInstance();
    }

    public static void main(String[] args) {
        launch();
    }
}