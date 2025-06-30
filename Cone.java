// Class representing a cone shape
public class Cone extends Shape {
    private double radius; // Radius of the cone
    private double height; // Height of the cone

    // Constructor to initialize a cone with radius and height
    public Cone(double radius, double height) {
        super("Cone", "cmÂ²");
        this.radius = radius;
        this.height = height;
    }

    // Calculate the surface area of the cone
    @Override
    public double calculateSurfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    // Calculate the volume of the cone
    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return radius <= 0 || height <= 0;
    }

    // Check if inputs for volume calculation are missing
    @Override
    public boolean areInputsMissingForVolume() {
        return radius <= 0 || height <= 0;
    }

    // Indicate that volume calculation is applicable for this shape
    @Override
    public boolean isVolumeApplicable() {
        return true;
    }
}
