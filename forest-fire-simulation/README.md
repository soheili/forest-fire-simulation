
The goal is to implement a simulation of forest fire propagation. 
Simulation Description

    Forest Representation: The forest is represented as a grid with dimensions h x l (height x width). Each cell in the grid can be in one of four states:
        Tree (T): Intact tree.
        Fire (F): A tree that is currently on fire.
        Burned (B): A tree that has burned out (represented as ashes, which can no longer catch fire).
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
