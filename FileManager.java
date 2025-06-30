import java.io.*;
import javax.swing.*;

// Define a class FileManager for handling file operations
public class FileManager {

    // Method to write shape data to a file
    public static void writeToFile(String shape, double value, String operation) {

        // Use try-with-resources to ensure the writer is closed after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("geometry_data.txt", true))) {
            
            // Write the shape, operation, and value to the file in a formatted manner
            writer.write(String.format("%s: %s = %.2f%n", shape, operation, value));
        } catch (IOException e) {
            
            // Show an error message if there is an issue with file writing
            JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
