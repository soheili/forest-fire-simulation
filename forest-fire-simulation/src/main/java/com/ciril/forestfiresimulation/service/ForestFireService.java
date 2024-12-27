package com.ciril.forestfiresimulation.service;

import com.ciril.forestfiresimulation.model.Forest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForestFireService {

    private Forest forest;

    // Method to initialize the forest with width, height, and initial state
    public void initializeForest(int width, int height, List<String> initialState) {
        forest = new Forest(width, height);  // Create a new forest object with the given dimensions
        forest.setInitialState(initialState);  // Set the initial state of the forest
    }

    // Method to retrieve the current grid of the forest
    public char[][] getGrid() {
        if (forest != null) {
            return forest.getGrid();  // Return the current state of the grid if the forest is initialized
        }
        return new char[0][0];  // Return an empty grid if the forest is not initialized
    }

    // Method to simulate the spreading of the fire
    public List<int[]> spreadFire(double propagationProbability) {
        if (forest != null) {
            return forest.spreadFire(propagationProbability);  // Spread the fire based on the given probability
        }
        return List.of();  // Return an empty list if the forest is not initialized
    }

    // Method to reset the forest
    public void resetForest(int width, int height, List<String> initialState) {
        initializeForest(width, height, initialState);  // Re-initialize the forest with the new dimensions and state
    }
}



