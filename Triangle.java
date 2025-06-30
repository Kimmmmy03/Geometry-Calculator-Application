// Class representing a triangle shape
public class Triangle extends Shape {
    private double base; // Base of the triangle
    private double height; // Height of the triangle

    // Constructor to initialize a triangle with base and height
    public Triangle(double base, double height) {
        super("Triangle", "cmÂ²");
        this.base = base;
        this.height = height;
    }

    // Calculate the surface area of the triangle
    @Override
    public double calculateSurfaceArea() {
        return 0.5 * base * height;
    }

    // Volume calculation is not applicable for 2D shapes, so this method throws UnsupportedOperationException
    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for 2D shapes.");
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return base <= 0 || height <= 0;
    }

    // Volume calculation is not applicable for 2D shapes, so return true
    @Override
    public boolean areInputsMissingForVolume() {
        return true; // Volume calculation is not applicable for 2D shapes
    }
}
