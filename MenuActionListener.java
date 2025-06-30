import java.awt.event.*;

// Define a class MenuActionListener that implements the ActionListener interface
public class MenuActionListener implements ActionListener {
    private GeometryCalculatorFrame frame;

    // Constructor for MenuActionListener that takes a GeometryCalculatorFrame as a parameter
    public MenuActionListener(GeometryCalculatorFrame frame) {
        this.frame = frame;
    }

    // Override the actionPerformed method to define what happens when an action is performed
    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the action command and convert it to lowercase
        String command = e.getActionCommand().toLowerCase();

        // Set the current shape in the frame based on the command
        frame.setCurrentShape(command);

        // Update the labels in the frame based on the command
        frame.updateLabels(command);

        // Set the fields in the frame to be editable based on the command
        frame.setFieldsEditable(command);

        // Clear the input fields in the frame
        frame.clearFields();
    }
}
