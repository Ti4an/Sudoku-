package com.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * @author Sebastian Bucheli Miranda
 * @version 1.0
 *
 * La clase HelpController maneja la lógica de la ventana de ayuda del Sudoku.
 */
public class HelpController {

    @FXML
    private ImageView howToImageView;
    /**
     * Cierra la ventana de ayuda cuando se hace clic en el botón de cerrar
     */
    @FXML
    void onXbutton(ActionEvent event) {
        Stage stage = (Stage) howToImageView.getScene().getWindow();
        stage.close();
    }
    /**
     * Inicializa la vista de ayuda cargando la imagen con las instrucciones del juego.
     */
    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/how-to.png"));
        this.howToImageView.setImage(image);
    }
}
