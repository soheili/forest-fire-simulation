package com.ciril.forestfiresimulation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forest {
    private char[][] grid;  // The forest grid (char[][])
    private static final char TREE = 'T';    // Intact tree
    private static final char FIRE = 'F';    // Burning tree
    private static final char BURNED = 'B';  // Burned tree
    private static final char EMPTY = '.';   // Empty cell

    // Constructor to initialize the forest with width and height
    public Forest(int width, int height) {
        this.grid = new char[height][width];
        // Initialize the grid with trees and empty cells (example)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = TREE;  // Initialize all trees as intact
            }
        }
    }

    // Method to set the initial state of the forest
    public void setInitialState(List<String> initialState) {
        for (int i = 0; i < initialState.size(); i++) {
            String row = initialState.get(i);  // Get each row
            for (int j = 0; j < row.length(); j++) {
                grid[i][j] = row.charAt(j);  // Assign each character (T, F, B, .)
            }
        }
    }

    // Method to spread the fire across the forest
    public List<int[]> spreadFire(double propagationProbability) {
        List<int[]> newFirePositions = new ArrayList<>();
        Random rand = new Random();

        // Traverse the grid to find burning trees
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == FIRE) {  // If a tree is on fire
                    // Mark the burning tree as burned
                    grid[i][j] = BURNED;

                    // Check the neighbors (up, down, left, right)
                    int[][] neighbors = {
                            {i - 1, j}, // up
                            {i + 1, j}, // down
                            {i, j - 1}, // left
                            {i, j + 1}  // right
                    };

                    for (int[] neighbor : neighbors) {
                        int ni = neighbor[0];
                        int nj = neighbor[1];

                        // Check if the neighbor is within the grid boundaries and is an intact tree
                        if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[i].length && grid[ni][nj] == TREE) {
                            // The fire spreads with a certain probability
                            if (rand.nextDouble() < propagationProbability) {
                                grid[ni][nj] = FIRE;  // The neighbor catches fire
                                newFirePositions.add(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }

        return newFirePositions;  // Return the new fire positions
    }

    // Return the current state of the grid
    public char[][] getGrid() {
        return grid;
    }

    // Method to reset the forest to its initial state
    public void reset() {
        // The forest can be reset here according to the initial state
        // This can be handled via the forest initialization or by creating a new instance.
    }
}

