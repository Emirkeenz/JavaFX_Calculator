# How to Run the Calculator Application

1. Ensure that Java and JavaFX are installed and properly configured on your system.
2. Clone the repository or download the project folder.
3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
4. Locate the main application file (e.g., `CalculatorApp.java`) and run it.
5. The calculator application window should open, ready for use.

# How to Use the Calculator

1. **Basic Operations**:
   - Click on digit buttons (`0-9`) to enter numbers.
   - Choose an operator (`+`, `-`, `×`, `÷`) for the desired arithmetic operation.
   - Click another number to complete the expression.
   - Press `=` to calculate and display the result.
   
2. **Clear Input**:
   - Press `AC` to reset the calculator and clear all inputs.

3. **Handling Division by Zero**:
   - If division by zero is attempted, an error message ("Error: Division by Zero") will be displayed.
   - Press `AC` to clear the error and reset the calculator.

# UI Screenshots
*(Insert screenshots showing examples of basic operations, an error for division by zero, and the clear functionality)*
<img width="408" alt="Снимок экрана 2024-10-19 в 17 13 14" src="https://github.com/user-attachments/assets/c3b07093-ccaf-40f7-83c6-eea001ffe443">

<img width="420" alt="Снимок экрана 2024-10-19 в 17 13 39" src="https://github.com/user-attachments/assets/29d2bdb1-2bb0-410f-a2b8-2093ceb5ac43">

# Special Instructions & Known Issues

1. **Special Instructions**:
   - Ensure JavaFX libraries are included in your project dependencies.
   - Use the "Clear" (`AC`) button to reset inputs if any issue arises during usage.

2. **Known Issues**:
   - Currently, multiple operators pressed sequentially may lead to unexpected behavior. 
     Always complete a calculation or reset before starting a new one.
   - The error state will block further input until `AC` is pressed.
