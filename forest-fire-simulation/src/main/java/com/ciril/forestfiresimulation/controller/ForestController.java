package com.ciril.forestfiresimulation.controller;

import com.ciril.forestfiresimulation.dto.ForestConfigDTO;
import com.ciril.forestfiresimulation.service.ForestFireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forest")
public class ForestController {

    @Autowired
    private ForestFireService forestFireService;

    // Initialize the forest with width, height, and initial state
    @PostMapping("/initialize")
    public ResponseEntity<String> initializeForest(@RequestBody ForestConfigDTO config) {
        try {
            // Calls the service method to initialize the forest with the provided configuration
            forestFireService.initializeForest(config.getWidth(), config.getHeight(), config.getInitialState());
            return ResponseEntity.ok("The forest has been successfully initialized.");
        } catch (Exception e) {
            // If there is an error during initialization, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    // Retrieve the current state of the forest grid
    @GetMapping("/grid")
    public ResponseEntity<char[][]> getForestGrid() {
        try {
            // Gets the current forest grid from the service
            char[][] grid = forestFireService.getGrid();
            return ResponseEntity.ok(grid);  // Return the grid in the response
        } catch (Exception e) {
            // If there is an error fetching the grid, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Simulate the propagation of fire with a given probability
    @PostMapping("/simulate")
    public ResponseEntity<String> simulateFire(@RequestParam double propagationProbability) {
        try {
            // Calls the service method to simulate fire spread and returns the new fire positions
            List<int[]> newFirePositions = forestFireService.spreadFire(propagationProbability);
            if (newFirePositions.isEmpty()) {
                // If there are no new fire positions, return a message indicating no further spread
                return ResponseEntity.ok("No further fire spread.");
            }
            // If the fire has spread, return a success message
            return ResponseEntity.ok("The fire has spread.");
        } catch (Exception e) {
            // If there is an error during fire propagation, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during fire propagation: " + e.getMessage());
        }
    }

    // Reset the forest to its initial state
    @PostMapping("/reset")
    public ResponseEntity<String> resetForest(@RequestBody ForestConfigDTO config) {
        try {
            // Calls the service method to reset the forest with the provided configuration
            forestFireService.resetForest(config.getWidth(), config.getHeight(), config.getInitialState());
            return ResponseEntity.ok("The forest has been successfully reset.");
        } catch (Exception e) {
            // If there is an error during the reset process, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during reset: " + e.getMessage());
        }
    }
}

