import javax.swing.SwingUtilities;

// Main application class for the Geometry Calculator
public class GeometryCalculatorApp {

    // Entry point of the application
    public static void main(String[] args) {

        // Launches the GUI on the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            
            // Creates and displays the main frame of the geometry calculator
            GeometryCalculatorFrame calculatorFrame = new GeometryCalculatorFrame();
            calculatorFrame.setVisible(true);
        });
    }
}
