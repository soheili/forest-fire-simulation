package com.ciril.forestfiresimulation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "forest")
public class ForestConfigProperties {
    private int width;
    private int height;
    private double propagationProbability;
    private List<String> initialState;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPropagationProbability() {
        return propagationProbability;
    }

    public void setPropagationProbability(double propagationProbability) {
        this.propagationProbability = propagationProbability;
    }

    public List<String> getInitialState() {
        return initialState;
    }

    public void setInitialState(List<String> initialState) {
        this.initialState = initialState;
    }
}
