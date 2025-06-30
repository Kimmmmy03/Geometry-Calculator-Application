// Class representing a cylinder shape
public class Cylinder extends Shape {
    private double radius; // Radius of the cylinder
    private double height; // Height of the cylinder

    // Constructor to initialize a cylinder with radius and height
    public Cylinder(double radius, double height) {
        super("Cylinder", "cmÂ²");
        this.radius = radius;
        this.height = height;
    }

    // Calculate the surface area of the cylinder
    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // Calculate the volume of the cylinder
    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
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
