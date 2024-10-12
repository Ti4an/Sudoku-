package com.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelpView extends Stage {
    public HelpView(Stage owner) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sudoku/how-to.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        this.initStyle(StageStyle.UNDECORATED);

        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(owner);

        this.centerOnScreen();
        this.setX(this.getX() + 100);

        this.setTitle("Sudoku");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/sudoku/img/question.png")));
        this.setScene(scene);
        this.showAndWait();
    }

    public static HelpView getInstance(Stage owner) throws IOException {
        if (HelpViewHolder.INSTANCE == null || !HelpViewHolder.INSTANCE.isShowing()) {
            HelpViewHolder.INSTANCE = new HelpView(owner);
        }
        return HelpViewHolder.INSTANCE;
    }

    private static class HelpViewHolder {
        private static HelpView INSTANCE;
    }
}
