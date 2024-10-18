package com.example.sudoku.controller;

import com.example.sudoku.view.GameView;
import com.example.sudoku.view.HelpView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * @author Sebastian Bucheli Miranda
 * @author 1.0
 *
 * La clase HomeController maneja la lógica de los eventos de la pantalla principal del Sudoku.
 */
public class HomeController {

    @FXML
    private ImageView logoImageView;
    /**
     * Cierra la ventana principal cuando se hace clic en el botón de salir.
     */
    @FXML
    void onExitButtonClick(ActionEvent event) {
        Stage stage = (Stage)this.logoImageView.getScene().getWindow();
        stage.close();
    }
    /**
     * Abre una nueva ventana con las instrucciones del juego cuando se hace clic en el botón de "Cómo jugar".
     */
    @FXML
    void onHowToButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpView.getInstance(stage);
    }
    /**
     * Cierra la ventana principal y abre la vista del juego cuando se hace clic en el botón de jugar.
     */
    @FXML
    void onPlayButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.logoImageView.getScene().getWindow();
        stage.close();
        GameView.getInstance();
    }
    /**
     * Inicializa la vista principal cargando el logotipo de la pantalla de inicio.
     */
    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/game2.png"));
        this.logoImageView.setImage(image);
    }
}