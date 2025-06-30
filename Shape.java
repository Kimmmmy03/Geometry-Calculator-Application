// Abstract class representing a geometric shape
public abstract class Shape {
    protected String name; // Name of the shape
    protected String unit; // Unit of measurement (e.g., cmÂ² or cmÂ³)

    // Constructor to initialize the shape with a name and unit
    public Shape(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    // Abstract method to calculate the surface area of the shape
    public abstract double calculateSurfaceArea();

    // Abstract method to calculate the volume of the shape
    public abstract double calculateVolume();

    // Abstract method to check if inputs are missing for surface area calculation
    public abstract boolean areInputsMissingForSurfaceArea();

    // Abstract method to check if inputs are missing for volume calculation
    public abstract boolean areInputsMissingForVolume();

    // Method to check if volume calculation is applicable (default is false)
    public boolean isVolumeApplicable() {
        return false;
    }

    // Getter for the name of the shape
    public String getName() {
        return name;
    }

    // Getter for the unit of measurement
    public String getUnit() {
        return unit;
    }
}
