// Class representing a circle shape
public class Circle extends Shape {
    private double radius; // Radius of the circle

    // Constructor to initialize a circle with radius
    public Circle(double radius) {
        super("Circle", "cmÂ²");
        this.radius = radius;
    }

    // Calculate the surface area of the circle
    @Override
    public double calculateSurfaceArea() {
        return Math.PI * radius * radius;
    }

    // Volume calculation is not applicable for 2D shapes, so this method throws UnsupportedOperationException
    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for 2D shapes.");
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return radius <= 0;
    }

    // Volume calculation is not applicable for 2D shapes, so return true
    @Override
    public boolean areInputsMissingForVolume() {
        return true; // Volume calculation is not applicable for 2D shapes
    }
}
