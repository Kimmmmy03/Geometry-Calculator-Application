// Class representing a sphere shape
public class Sphere extends Shape {
    private double radius; // Radius of the sphere

    // Constructor to initialize a sphere with radius
    public Sphere(double radius) {
        super("Sphere", "cmÂ²");
        this.radius = radius;
    }

    // Calculate the surface area of the sphere
    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    // Calculate the volume of the sphere
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    // Check if inputs for surface area calculation are missing
    @Override
    public boolean areInputsMissingForSurfaceArea() {
        return radius <= 0;
    }

    // Check if inputs for volume calculation are missing
    @Override
    public boolean areInputsMissingForVolume() {
        return radius <= 0;
    }

    // Indicate that volume calculation is applicable for this shape
    @Override
    public boolean isVolumeApplicable() {
        return true;
    }
}
