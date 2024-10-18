package com.example.sudoku.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
/**
 * @author Sebastian Bucheli Miranda
 * @version 1.0
 *
 * La clase GameView crea y configura la ventana principal del juego de Sudoku.
 */
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
    /**
     * Devuelve una instancia única de GameView usando el patrón Singleton.
     */
    public static GameView getInstance() throws IOException {
        return GameView.GameViewHolder.INSTANCE = new GameView();
    }
    /**
     * Clase estática interna que sostiene la instancia Singleton de GameView.
     */
    private static class GameViewHolder {
        private static GameView INSTANCE;
    }
}
