package com.example.sudoku.models;

import java.util.*;

/**
 * @author Sebastian Bucheli Miranda
 * @version 1.0
 *
 * La clase SudokuModel maneja la lógica y los datos de un juego de Sudoku de 6x6.
 */
public class SudokuModel {

    private ArrayList<ArrayList<Integer>> solution;
    private ArrayList<ArrayList<Integer>> board;
    /**
     * Constructor de SudokuModel que inicializa la solución predefinida
     */
    public SudokuModel() {

        solution = new ArrayList<>();
        board = new ArrayList<>();

        initializeSolution();
        initializeBoardWithHiddenCells();
    }

    /**
     * Inicializa la solución predefinida del Sudoku.
     */
    private void initializeSolution() {
        solution = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            solution.add(new ArrayList<>(Collections.nCopies(6, 0)));
        }

        generateSolution(0, 0);
    }

    /**
     * Genera una solución completa de Sudoku usando backtracking.
     */
    private boolean generateSolution(int row, int col) {
        if (row == 6) {
            return true;
        }


        int nextRow = (col == 5) ? row + 1 : row;
        int nextCol = (col == 5) ? 0 : col + 1;


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(numbers);

        for (int num : numbers) {
            if (canPlaceNumber(row, col, num)) {
                solution.get(row).set(col, num);

                if (generateSolution(nextRow, nextCol)) {
                    return true;
                }


                solution.get(row).set(col, 0);
            }
        }

        return false;
    }

    private boolean canPlaceNumber(int row, int col, int num) {

        for (int i = 0; i < 6; i++) {
            if (solution.get(row).get(i) == num) {
                return false;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (solution.get(i).get(col) == num) {
                return false;
            }
        }

        int rowBlock = (row / 2) * 2;
        int colBlock = (col / 3) * 3;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (solution.get(rowBlock + i).get(colBlock + j) == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Copia la solución al tablero visible y oculta algunas celdas aleatoriamente.
     */
    private void initializeBoardWithHiddenCells() {

        for (int i = 0; i < 6; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                row.add(solution.get(i).get(j));
            }
            board.add(row);
        }
        Random random = new Random();
        for (int rowBlock = 0; rowBlock < 6; rowBlock += 2) {
            for (int colBlock = 0; colBlock < 6; colBlock += 3) {
                List<int[]> positions = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        positions.add(new int[]{rowBlock + i, colBlock + j});
                    }
                }
                int[] firstPos = positions.remove(random.nextInt(positions.size()));
                int[] secondPos = positions.remove(random.nextInt(positions.size()));

                for (int[] pos : positions) {
                    board.get(pos[0]).set(pos[1], 0); // Ocultar las celdas restantes
                }
            }
        }
    }

    /**
     * Obtiene el valor actual en una celda del tablero visible.
     *
     * @param row
     * @param col
     * @return El valor en la celda del tablero.
     */
    public int getValue(int row, int col) {
        return board.get(row).get(col);
    }

    /**
     * Establece un valor en una celda del tablero visible.
     *
     * @param row
     * @param col
     * @param value
     */
    public void setValue(int row, int col, int value) {
        if (isValidValue(value)) {
            board.get(row).set(col, value);
        }
    }

    /**
     * Verifica si el valor ingresado está entre 1 y 6.
     *
     * @param value
     */
    private boolean isValidValue(int value) {
        return value >= 1 && value <= 6;
    }
    /**
     * Obtiene el valor de la solución correcta en una celda.
     *
     * @param row
     * @param col
     */
    public int getSolutionValue(int row, int col) {
        return solution.get(row).get(col);
    }
    /**
     * Verifica si el valor ingresado en una celda es correcto.
     *
     * @param row
     * @param col
     */
    public boolean isCorrect(int row, int col) {
        return board.get(row).get(col) == solution.get(row).get(col);
    }
    /**
     * Verifica si todas las celdas del tablero están completas y correctas.
     *
     * @return true si el tablero está completo y correcto, false en caso contrario.
     */
    public boolean isCompleteAndCorrect() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.get(i).get(j) == 0 || !isCorrect(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
