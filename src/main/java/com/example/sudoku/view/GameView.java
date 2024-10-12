package com.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameView extends Stage {
    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sudoku/game-view.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        this.initStyle(StageStyle.UNDECORATED);
        this.setTitle("Sudoku");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/sudoku/img/game.png")));
        this.setScene(scene);
        this.show();
    }

    public static GameView getInstance() throws IOException {
        return GameView.GameViewHolder.INSTANCE = new GameView();
    }

    private static class GameViewHolder {
        private static GameView INSTANCE;
    }
}
