package com.example.sudoku.controller;

import com.example.sudoku.models.SudokuModel;
import com.example.sudoku.view.HelpView;
import com.example.sudoku.view.HomeView;
import com.example.sudoku.view.alert.AlertBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.geometry.Insets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Sebastian Bucheli Miranda
 * @version 1.0
 *
 * La clase GameController maneja la lógica de la vista principal del juego de Sudoku.
 * Controla la interacción con los botones, la actualización del tablero, el cronómetro,
 */
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
    private TextField[][] boxes;

    @FXML
    private GridPane gridPane1;

    @FXML
    private GridPane gridPane2;

    @FXML
    private GridPane gridPane3;

    @FXML
    private GridPane gridPane4;

    @FXML
    private GridPane gridPane5;

    @FXML
    private GridPane gridPane6;

    @FXML
    private Label timeLabel;

    private Timeline timeline;
    private LocalTime startTime;
    private LocalTime endTime;
    private SudokuModel model;
    private Random random;
    /**
     * Proporciona una pista aleatoria al jugador.
     */
    @FXML
    void onHintButton(ActionEvent event) {
        giveRandomHint();
    }
    /**
     * Llama a la vista de ayuda.
     */
    @FXML
    void onHelpButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        HelpView.getInstance(stage);
    }
    /**
     * Regresa al menú principal.
     */
    @FXML
    void onHomeButton(ActionEvent event) throws IOException {
        Stage stage = (Stage)this.logoImageView.getScene().getWindow();
        stage.close();
        HomeView.getInstance();
    }
    /**
     * Reinicia el tablero y el cronómetro.
     */
    @FXML
    void onReloadButton(ActionEvent event) {
        model = new SudokuModel();
        loadBoardFromModel();
        resetTimer();
    }
    /**
     * Cierra la ventana actual del juego.
     */
    @FXML
    void onXButton(ActionEvent event) {
        Stage stage = (Stage) logo2ImageView.getScene().getWindow();
        stage.close();
    }
    /**
     * Inicializa la vista del juego, el cronómetro y los componentes de la interfaz.
     */
    public void initialize() {
        startTimer();
        model = new SudokuModel();
        random = new Random();
        createTextField();


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

        loadBoardFromModel();
    }


    /**
     * Crea los campos de texto para el tablero de Sudoku y configura las validaciones.
     */
    public void createTextField() {
        boxes = new TextField[6][6]; // Inicializar la matriz de TextFields

        GridPane[] gridPanes = {gridPane1, gridPane2, gridPane3, gridPane4, gridPane5, gridPane6};


        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 2; blockCol++) {

                int gridPaneIndex = blockRow * 2 + blockCol;
                GridPane currentGridPane = gridPanes[gridPaneIndex];

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = blockRow * 2 + i;
                        int col = blockCol * 3 + j;

                        TextField field = new TextField();
                        field.setPrefWidth(48);
                        field.setPrefHeight(48);
                        field.setMaxWidth(Double.MAX_VALUE);
                        field.setMaxHeight(Double.MAX_VALUE);

                        field.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;");

                        field.setAlignment(Pos.CENTER);

                        GridPane.setMargin(field, new Insets(1));
                        currentGridPane.add(field, j, i);
                        boxes[row][col] = field;


                        field.textProperty().addListener((observable, oldValue, newValue) -> {
                            if (newValue.length() > 1) {
                                field.setText(oldValue);
                            } else if (!newValue.matches("[1-6]?")) {
                                field.setText("");
                                field.setStyle("-fx-background-color: lightcoral; -fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;"); // Cambiar el color si es inválido
                            } else {
                                if (!newValue.isEmpty()) {
                                    int value = Integer.parseInt(newValue);
                                    model.setValue(row, col, value);

                                    if (model.isCorrect(row, col)) {
                                        field.setStyle("-fx-background-color: lightgreen; -fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;"); // Cambiar a verde si es correcto
                                    } else {
                                        field.setStyle("-fx-background-color: lightcoral; -fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;"); // Cambiar a rojo si es incorrecto
                                    }
                                    checkIfGameIsWon();
                                } else {
                                    model.setValue(row, col, 0); // Si el campo está vacío, poner 0 en el modelo
                                    field.setStyle("-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;"); // Restaurar el estilo sin color
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /**
     * Carga los valores del modelo de Sudoku en los TextFields de la interfaz.
     */
    private void loadBoardFromModel() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int value = model.getValue(i, j);
                if (value != 0) {
                    boxes[i][j].setText(String.valueOf(value));
                    boxes[i][j].setEditable(false);
                } else {
                    boxes[i][j].setText("");
                    boxes[i][j].setEditable(true);
                }
            }
        }
    }

    /**
     * Proporciona una pista aleatoria llenando una celda con el valor correcto.
     */
    private void giveRandomHint() {
        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (model.getValue(i, j) == 0 || !model.isCorrect(i, j)) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        if (emptyCells.size() <= 1) {
            AlertBox alertBox = new AlertBox();
            alertBox.warningAlert("No hints", null, "No hints can be given, you are almost done with the Sudoku.");
            return;
        }

        int[] cell = emptyCells.get(random.nextInt(emptyCells.size()));
        int row = cell[0];
        int col = cell[1];

        int solutionValue = model.getSolutionValue(row, col);
        model.setValue(row, col, solutionValue);

        boxes[row][col].setText(String.valueOf(solutionValue));
        boxes[row][col].setStyle("-fx-background-color: lightgreen;-fx-font-family: 'Arial'; -fx-font-weight: bold; -fx-font-size: 16px; -fx-alignment: center;"); // Marcar en verde como pista
    }

    /**
     * Verifica si el jugador ha completado correctamente el Sudoku.
     * Si ha ganado, detiene el cronómetro y muestra un mensaje de victoria.
     */
    private void checkIfGameIsWon() {
        boolean isCompleteAndCorrect = model.isCompleteAndCorrect();

        if (isCompleteAndCorrect) {
            stopTimer();
            AlertBox alertBox = new AlertBox();
            String info = ("Tiempo total: " + formatTime(startTime));
            alertBox.infoAlert("You Win!", "",info );
        }
    }
    /**
     * Inicia el cronómetro que cuenta el tiempo desde el inicio del juego.
     */
    private void startTimer() {
        startTime = LocalTime.of(0, 0, 0);


        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            startTime = startTime.plusSeconds(1);
            timeLabel.setText(startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Detiene el cronómetro.
     */
    private void stopTimer() {
        if (timeline != null) {
            timeline.stop();
            endTime = startTime;
        }
    }

    /**
     * Formatea el tiempo en formato HH:mm:ss.
     */
    private String formatTime(LocalTime time) {

        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * Reinicia el cronómetro a 00:00:00.
     */
    private void resetTimer() {
        if (timeline != null) {
            timeline.stop();
        }

        startTime = LocalTime.of(0, 0, 0);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            startTime = startTime.plusSeconds(1);
            timeLabel.setText(startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));

        timeline.setCycleCount(Timeline.INDEFINITE); // Para que siga ejecutándose indefinidamente
        timeline.play();
    }
}
