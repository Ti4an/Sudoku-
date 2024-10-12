package com.example.sudoku.view.alert;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AlertBox {
    public AlertBox() {
    }

    public void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void warningAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void infoAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText((String)null);
        Image image = new Image(this.getClass().getResourceAsStream("/com/example/elsoleclipsado/images/help.png"));
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);
        alert.getDialogPane().setPrefSize(400.0, 400.0);
        alert.showAndWait();
    }
}
