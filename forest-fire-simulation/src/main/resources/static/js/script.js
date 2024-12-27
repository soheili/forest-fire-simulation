const GRID_SIZE = 20; // Size of the grid (default 20x20)
let grid = []; // Representation of the forest grid
let firePositions = []; // List of the positions of the cells on fire
let step = 0; // Counter for the simulation steps

// Select HTML elements
const gridContainer = document.getElementById('grid');
const stepCountElement = document.getElementById('stepCount');
const startButton = document.getElementById('startButton');
const nextStepButton = document.getElementById('nextStepButton');
const resetButton = document.getElementById('resetButton');

// Initialize a default grid with fire at the center
function initializeGrid() {
    grid = Array.from({ length: GRID_SIZE }, () =>
        Array.from({ length: GRID_SIZE }, () => 'T')
    );
    const center = Math.floor(GRID_SIZE / 2);
    grid[center][center] = 'F'; // Place fire at the center of the grid
    initializeFirePositions(); // Set the initial fire positions
    renderGrid(); // Render the grid in the UI
    step = 0; // Reset the simulation step counter
    updateStepCount(); // Update the step count display
}

// Initialize the positions of the cells on fire
function initializeFirePositions() {
    firePositions = [];
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] === 'F') {
                firePositions.push({ x: i, y: j }); // Add fire positions to the list
            }
        }
    }
}

// Render the grid to the DOM
function renderGrid() {
    gridContainer.innerHTML = ''; // Clear previous grid content
    gridContainer.style.gridTemplateColumns = `repeat(${GRID_SIZE}, 20px)`; // Set the number of columns in the grid
    gridContainer.style.gridTemplateRows = `repeat(${GRID_SIZE}, 20px)`; // Set the number of rows in the grid

    grid.forEach(row => {
        row.forEach(cellType => {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            if (cellType === 'F') {
                cell.classList.add('fire'); // Apply 'fire' style for burning cells
            } else if (cellType === 'T') {
                cell.classList.add('tree'); // Apply 'tree' style for intact trees
            } else if (cellType === 'B') {
                cell.classList.add('burned'); // Apply 'burned' style for burned cells
            }
            gridContainer.appendChild(cell); // Append the cell to the grid container
        });
    });
}

// Spread the fire to adjacent cells
function spreadFire() {
    const newFirePositions = [];

    firePositions.forEach(({ x, y }) => {
        grid[x][y] = 'B'; // Mark the cell as burned

        const neighbors = [
            { x: x - 1, y }, // Up
            { x: x + 1, y }, // Down
            { x, y: y - 1 }, // Left
            { x, y: y + 1 }  // Right
        ];

        neighbors.forEach(({ x, y }) => {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] === 'T') {
                if (Math.random() < 0.8) { // Fire spread probability (80%)
                    grid[x][y] = 'F'; // Set the neighboring tree on fire
                    newFirePositions.push({ x, y }); // Add the new fire position to the list
                }
            }
        });
    });

    firePositions = newFirePositions; // Update the list of fire positions
    renderGrid(); // Re-render the grid after fire spread
}

// Execute one step of the simulation
function nextStep() {
    if (firePositions.length === 0) {
        alert("The fire has been extinguished!"); // Stop the simulation if there is no fire left
        return;
    }

    spreadFire(); // Spread the fire to neighboring cells
    step++; // Increment the simulation step
    updateStepCount(); // Update the step count display
}

// Update the step count display
function updateStepCount() {
    stepCountElement.textContent = step; // Update the displayed step count
}

// Reset the simulation to its initial state
function resetSimulation() {
    initializeGrid(); // Re-initialize the grid and fire positions
}

// Add event listeners to the buttons
startButton.addEventListener('click', initializeGrid); // Start button initializes the grid
nextStepButton.addEventListener('click', nextStep); // Next step button advances the simulation
resetButton.addEventListener('click', resetSimulation); // Reset button resets the simulation

// Initialize the simulation when the page loads
initializeGrid(); // Initialize the grid at the start


