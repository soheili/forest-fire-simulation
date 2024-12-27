package com.ciril.forestfiresimulation.dto;

import java.util.List;

public class ForestConfigDTO {
    private int width;  // Width of the forest
    private int height; // Height of the forest
    private double propagationProbability; // Probability of fire propagation
    private List<String> initialState; // List of strings representing the initial state of the forest

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(int width) {
        this.width = width;
    }

    // Getter for height
    public int getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(int height) {
        this.height = height;
    }

    // Getter for propagation probability
    public double getPropagationProbability() {
        return propagationProbability;
    }

    // Setter for propagation probability
    public void setPropagationProbability(double propagationProbability) {
        this.propagationProbability = propagationProbability;
    }

    // Getter for the initial state of the forest
    public List<String> getInitialState() {
        return initialState;
    }

    // Setter for the initial state of the forest
    public void setInitialState(List<String> initialState) {
        this.initialState = initialState;
    }
}
