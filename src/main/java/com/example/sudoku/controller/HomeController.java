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

public class HomeController {

    @FXML
    private ImageView logoImageView;

    @FXML
    void onExitButtonClick(ActionEvent event) {
        Stage stage = (Stage)this.logoImageView.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onHowToButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpView.getInstance(stage);
    }

    @FXML
    void onPlayButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.logoImageView.getScene().getWindow();
        stage.close();
        GameView.getInstance();
    }

    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/game2.png"));
        this.logoImageView.setImage(image);
    }
}