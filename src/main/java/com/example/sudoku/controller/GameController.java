package com.example.sudoku.controller;

import com.example.sudoku.view.HelpView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class GameController {
    @FXML
    private Button hintButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button reloadButton;

    @FXML
    private ImageView logo2ImageView;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField textField_00;

    @FXML
    private TextField textField_01;

    @FXML
    private TextField textField_02;

    @FXML
    private TextField textField_03;

    @FXML
    private TextField textField_04;

    @FXML
    private TextField textField_05;

    @FXML
    private TextField textField_10;

    @FXML
    private TextField textField_11;

    @FXML
    private TextField textField_12;

    @FXML
    private TextField textField_13;

    @FXML
    private TextField textField_14;

    @FXML
    private TextField textField_15;

    @FXML
    private TextField textField_20;

    @FXML
    private TextField textField_21;

    @FXML
    private TextField textField_22;

    @FXML
    private TextField textField_23;

    @FXML
    private TextField textField_24;

    @FXML
    private TextField textField_25;

    @FXML
    private TextField textField_30;

    @FXML
    private TextField textField_31;

    @FXML
    private TextField textField_32;

    @FXML
    private TextField textField_33;

    @FXML
    private TextField textField_34;

    @FXML
    private TextField textField_35;

    @FXML
    private TextField textField_40;

    @FXML
    private TextField textField_41;

    @FXML
    private TextField textField_42;

    @FXML
    private TextField textField_43;

    @FXML
    private TextField textField_44;

    @FXML
    private TextField textField_45;

    @FXML
    private TextField textField_50;

    @FXML
    private TextField textField_51;

    @FXML
    private TextField textField_52;

    @FXML
    private TextField textField_53;

    @FXML
    private TextField textField_54;

    @FXML
    private TextField textField_55;

    @FXML
    private Label timeLabel;

    @FXML
    void onHintButton(ActionEvent event) {

    }

    @FXML
    void onHelpButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpView.getInstance(stage);
    }

    @FXML
    void onHomeButton(ActionEvent event) {

    }

    @FXML
    void onReloadButton(ActionEvent event) {

    }

    @FXML
    void onXButton(ActionEvent event) {
        Stage stage = (Stage) logo2ImageView.getScene().getWindow();
        stage.close();
    }

    public void initialize(){
        Image image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/game3.png"));
        this.logo2ImageView.setFitHeight(131);
        this.logo2ImageView.setFitWidth(186);
        this.logo2ImageView.setImage(image);
        image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/title.png"));
        this.logoImageView.setImage(image);

        image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/hint.png"));
        ImageView imageViewHint = new ImageView(image);
        imageViewHint.setFitHeight(25);
        imageViewHint.setFitWidth(25);
        this.hintButton.setGraphic(imageViewHint);


        image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/reload.png"));
        ImageView imageViewReload = new ImageView(image);
        imageViewReload.setFitHeight(25);
        imageViewReload.setFitWidth(25);
        this.reloadButton.setGraphic(imageViewReload);


        image = new Image(getClass().getResourceAsStream("/com/example/sudoku/img/home.png"));
        ImageView imageViewHome = new ImageView(image);
        imageViewHome.setFitHeight(25);
        imageViewHome.setFitWidth(25);
        this.homeButton.setGraphic(imageViewHome);
    }
}
