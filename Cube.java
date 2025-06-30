// Class representing a cube shape
public class Cube extends Shape {
    private double length; // Length of the cube

    // Constructor to initialize a cube with length
    public Cube(double length) {
        super("Cube", "cmÂ²");
        this.length = length;
    }

    // Calculate the surface area of the cube
    @Override
    public double calculateSurfaceArea() {
        return 6 * length * length;
    }

    // Calculate the volume of the cube
    @Override
    public double calculateVolume() {
        return length * length * length;
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return length <= 0;
    }

    // Check if inputs for volume calculation are missing
    @Override
    public boolean areInputsMissingForVolume() {
        return length <= 0;
    }

    // Indicate that volume calculation is applicable for this shape
    @Override
    public boolean isVolumeApplicable() {
        return true;
    }
}
