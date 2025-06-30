public class ShapeCalculator {
    // Checks if necessary inputs are missing for calculating surface area of a shape
    public static boolean areInputsMissingForSurfaceArea(Shape shape) {
        return shape.areInputsMissingForSurfaceArea();
    }

    // Checks if necessary inputs are missing for calculating volume of a shape
    public static boolean areInputsMissingForVolume(Shape shape) {
        return shape.areInputsMissingForVolume();
    }

    // Calculates the surface area of a shape
    public static double calculateSurfaceArea(Shape shape) {
        return shape.calculateSurfaceArea();
    }

    // Calculates the volume of a shape
    public static double calculateVolume(Shape shape) {
        return shape.calculateVolume();
    }
}
