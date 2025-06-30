// Class representing a cuboid shape
public class Cuboid extends Shape {
    private double length; // Length of the cuboid
    private double width;  // Width of the cuboid
    private double height; // Height of the cuboid

    // Constructor to initialize a cuboid with length, width, and height
    public Cuboid(double length, double width, double height) {
        super("Cuboid", "cmÂ³");
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Calculate the surface area of the cuboid
    @Override
    public double calculateSurfaceArea() {
        return 2 * (length * width + width * height + height * length);
    }

    // Calculate the volume of the cuboid
    @Override
    public double calculateVolume() {
        return length * width * height;
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return length <= 0 || width <= 0 || height <= 0;
    }

    // Check if inputs for volume calculation are missing
    @Override
    public boolean areInputsMissingForVolume() {
        return length <= 0 || width <= 0 || height <= 0;
    }

    // Indicate that volume calculation is applicable for this shape
    @Override
    public boolean isVolumeApplicable() {
        return true;
    }
}
