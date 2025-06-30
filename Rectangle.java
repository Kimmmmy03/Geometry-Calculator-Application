// Class representing a rectangle shape
public class Rectangle extends Shape {
    private double length; // Length of the rectangle
    private double width; // Width of the rectangle

    // Constructor to initialize a rectangle with length and width
    public Rectangle(double length, double width) {
        super("Rectangle", "cmÂ²");
        this.length = length;
        this.width = width;
    }

    // Calculate the surface area of the rectangle
    @Override
    public double calculateSurfaceArea() {
        return length * width;
    }

    // Volume calculation is not applicable for 2D shapes, so this method throws UnsupportedOperationException
    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for 2D shapes.");
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return length <= 0 || width <= 0;
    }

    // Volume calculation is not applicable for 2D shapes, so return true
    @Override
    public boolean areInputsMissingForVolume() {
        return true; // Volume calculation is not applicable for 2D shapes
    }
}
