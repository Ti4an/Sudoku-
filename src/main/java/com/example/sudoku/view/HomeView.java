package com.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeView extends Stage {
    public HomeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sudoku/home-view.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        this.initStyle(StageStyle.UNDECORATED);
        this.setTitle("Sudoku");
        this.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/example/sudoku/img/game.png")));
        this.setScene(scene);
        this.show();
    }

    public static HomeView getInstance() throws IOException {
        return HomeView.HomeViewHolder.INSTANCE = new HomeView();
    }

    private static class HomeViewHolder {
        private static HomeView INSTANCE;
    }
}
