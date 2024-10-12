package com.example.sudoku.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelpController {

    @FXML
    private ImageView howToImageView;

    @FXML
    void onXbutton(ActionEvent event) {
        Stage stage = (Stage) howToImageView.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/how-to.png"));
        this.howToImageView.setImage(image);
    }
}
