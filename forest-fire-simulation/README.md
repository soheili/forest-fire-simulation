Forest Fire Simulation Application

The goal is to implement a simulation of forest fire propagation. 
This project demonstrates the integration of backend computation with a responsive user interface, offering insights into forest fire behavior and aiding in understanding potential preventative measures.

Overview

This application simulates forest fires by combining a robust backend developed with Spring Boot and a dynamic frontend built with JavaScript. The backend is responsible for handling the simulation logic, including modeling fire spread dynamics, environmental factors such as e.g., wind speed, humidity (in future work), and state changes. It also provides RESTful endpoints to facilitate communication with the frontend.

Application Installation

Prerequisites
Java 11 or higher
Maven

Steps
Clone the repository:
git clone https://github.com/soheili/forest-fire-simulation.git
cd forst-fire-simulation

Build backend
Navigate to the backend directory: root of project
Build the backend using Maven:
mvn clean install
./mvnw spring-boot:run

Following URL in browser:
http://localhost:8080/html.index

Simulation Description

    Forest Representation: The forest is represented as a grid with dimensions h x l (height x width). Each cell in the grid can be in one of four states:
        Tree (T): Intact tree.
        Fire (F): A tree that is currently on fire.
        Burned (B): A tree that has burned out (represented as ashes,    which can no longer catch fire).
        Empty (.): An empty cell.

    Discrete Time Steps: The simulation progresses step by step (discrete time).

    Initial State:
        At least one cell is initially set on fire.
        The positions of these burning cells are defined in the program's configuration.

    Fire Propagation Rules:
        If a cell is on fire at step t, then at step t+1:
            The fire in this cell burns out, leaving it in a Burned state.
            There is a probability p that the fire spreads to each of the 4 adjacent cells (up, down, left, and right).
        Once burned, a cell cannot catch fire again.

    Simulation End Condition:
        The simulation ends when there are no more burning cells in the grid.

    Configuration:
        Grid dimensions (h and l).
        Initial positions of burning cells.
        Fire propagation probability (p).
        These parameters should be stored in a configuration file.

Explanation of the Process
1. Problem Analysis
* Identify the core components of the problem:
o Forest grid representation.
o Discrete time steps and fire propagation rules.
o Simulation lifecycle and stopping conditions.
* Clarify inputs (grid dimensions, initial state, propagation probability).
* Define the outputs (state of the grid at each time step, stopping condition).
2. Design and Architecture
* Choose an object-oriented approach:
o A Forest class to manage the grid and its state.
o A Simulation class to control the progression of the simulation.
* Define configuration management:
o Use a configuration file (e.g., JSON or YAML) to store parameters.
* Modularize the code:
o Separate responsibilities into different components (e.g., grid initialization, fire propagation logic, and output visualization).
3. Implementation
* Forest Class:
o Initialize the grid with the given dimensions and initial states.
o Implement methods for fire propagation and state updates.
* Simulation Class:
o Load configuration parameters.
o Manage the lifecycle of the simulation (steps and stopping conditions).
o Track and log the state of the grid at each step.
* Configuration Handling:
o Use a library (e.g., JSON in Java) to parse the configuration file.
* Visualization:
o Console-based visualization of the grid at each step.
o Optional: Extend to a graphical interface (e.g., using HTML/CSS/JavaScript).
4. Testing
* Unit test individual components (e.g., fire propagation logic, grid initialization).
* Run integration tests to ensure all components work together.
* Validate with edge cases (e.g., 0% or 100% propagation probability, very small or very large grids).
5. Simulation Execution
* Load the configuration file.
* Initialize the forest and set the initial state.
* Run the simulation step-by-step, applying the fire propagation rules.
* Stop when no cells are on fire.
6. Presentation of Results
* Document the architectural choices:
o Explain the class structure and interaction between components.
o Highlight scalability and maintainability considerations.
* Provide sample runs with various configurations.
* Include visualizations of the grid at different steps of the simulation.



