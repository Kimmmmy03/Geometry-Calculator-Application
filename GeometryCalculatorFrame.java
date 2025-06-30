import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Frame class for the Geometry Calculator
public class GeometryCalculatorFrame extends JFrame {
    private JTextField lengthField, widthField, radiusField, baseField, heightField;
    private JButton calculateButton, volumeButton;
    private JLabel shapeNameLabel, formulaLabel;
    private JMenuItem circleItem, rectangleItem, triangleItem, sphereItem, cubeItem, cylinderItem, cuboidItem, coneItem;
    private String currentShape;
    private JTextArea displayArea;

    // Constructor to initialize the frame
    public GeometryCalculatorFrame() {
        setTitle("Geometry Calculator");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar(); // Create menu bar
        createMainLayout(); // Create main UI layout
    }

    // Method to create the menu bar
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu shapeMenu = new JMenu("Shapes");
        shapeMenu.setMnemonic(KeyEvent.VK_S);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        MenuActionListener menuListener = new MenuActionListener(this);

        // Creating menu items for shapes
        circleItem = createMenuItem("Circle", KeyEvent.VK_1, menuListener);
        rectangleItem = createMenuItem("Rectangle", KeyEvent.VK_2, menuListener);
        triangleItem = createMenuItem("Triangle", KeyEvent.VK_3, menuListener);
        sphereItem = createMenuItem("Sphere", KeyEvent.VK_4, menuListener);
        cubeItem = createMenuItem("Cube", KeyEvent.VK_5, menuListener);
        cylinderItem = createMenuItem("Cylinder", KeyEvent.VK_6, menuListener);
        cuboidItem = createMenuItem("Cuboid", KeyEvent.VK_7, menuListener);
        coneItem = createMenuItem("Cone", KeyEvent.VK_8, menuListener);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.addActionListener(new SaveListener());

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setMnemonic(KeyEvent.VK_L);
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        loadItem.addActionListener(new LoadListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.addActionListener(e -> System.exit(0));

        // Adding items to respective menus
        shapeMenu.add(circleItem);
        shapeMenu.add(rectangleItem);
        shapeMenu.add(triangleItem);
        shapeMenu.add(sphereItem);
        shapeMenu.add(cubeItem);
        shapeMenu.add(cylinderItem);
        shapeMenu.add(cuboidItem);
        shapeMenu.add(coneItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        menuBar.add(shapeMenu);
        menuBar.add(fileMenu);
        menuBar.add(exitItem);

        setJMenuBar(menuBar);
    }

    // Method to create a menu item
    private JMenuItem createMenuItem(String shape, int keyEvent, MenuActionListener listener) {
        JMenuItem item = new JMenuItem(shape);
        item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, ActionEvent.CTRL_MASK));
        item.addActionListener(listener);
        return item;
    }

    // Method to create a button with an operation
    private JButton createButton(String operation) {
        JButton button = new JButton(operation);
        button.addActionListener(e -> performCalculation(operation.toLowerCase()));
        return button;
    }

    // Method to create the main UI layout
    private void createMainLayout() {
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new GridLayout(2, 1));
        shapeNameLabel = new JLabel("Select a shape", SwingConstants.CENTER);
        formulaLabel = new JLabel("", SwingConstants.CENTER);
        northPanel.add(shapeNameLabel);
        northPanel.add(formulaLabel);
        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(15, 1));
        lengthField = new JTextField(5);
        widthField = new JTextField(5);
        radiusField = new JTextField(5);
        baseField = new JTextField(5);
        heightField = new JTextField(5);

        centerPanel.add(new JLabel("Length (CM)"));
        centerPanel.add(lengthField);
        centerPanel.add(new JSeparator());
        centerPanel.add(new JLabel("Width (CM)"));
        centerPanel.add(widthField);
        centerPanel.add(new JSeparator());
        centerPanel.add(new JLabel("Radius (CM)"));
        centerPanel.add(radiusField);
        centerPanel.add(new JSeparator());
        centerPanel.add(new JLabel("Base (CM)"));
        centerPanel.add(baseField);
        centerPanel.add(new JSeparator());
        centerPanel.add(new JLabel("Height (CM)"));
        centerPanel.add(heightField);
        centerPanel.add(new JSeparator());

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        calculateButton = createButton("Calculate Surface Area");
        volumeButton = createButton("Calculate Volume");
        buttonPanel.add(calculateButton);
        buttonPanel.add(volumeButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setRows(10);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(scrollPane, BorderLayout.CENTER);

        add(southPanel, BorderLayout.SOUTH);
    }

    // Method to update labels based on selected shape
    public void updateLabels(String shape) {
        switch (shape) {
            case "circle":
                shapeNameLabel.setText("Circle");
                formulaLabel.setText("<html>Area = Ï€ * Radius^2</html>");
                break;
            case "rectangle":
                shapeNameLabel.setText("Rectangle");
                formulaLabel.setText("<html>Area = Length * Width</html>");
                break;
            case "triangle":
                shapeNameLabel.setText("Triangle");
                formulaLabel.setText("<html>Area = 0.5 * Base * Height</html>");
                break;
            case "sphere":
                shapeNameLabel.setText("Sphere");
                formulaLabel.setText("<html>Surface Area = 4 * Ï€ * Radius^2<br>Volume = (4/3) * Ï€ * Radius^3</html>");
                break;
            case "cube":
                shapeNameLabel.setText("Cube");
                formulaLabel.setText("<html>Surface Area = 6 * Length^2<br>Volume = Length^3</html>");
                break;
            case "cylinder":
                shapeNameLabel.setText("Cylinder");
                formulaLabel.setText("<html>Surface Area = 2 * Ï€ * Radius * (Radius + Height)<br>Volume = Ï€ * Radius^2 * Height</html>");
                break;
            case "cuboid":
                shapeNameLabel.setText("Cuboid");
                formulaLabel.setText("<html>Surface Area = 2 * (Length*Width + Width*Height + Height*Length)<br>Volume = Length * Width * Height</html>");
                break;
            case "cone":
                shapeNameLabel.setText("Cone");
                formulaLabel.setText("<html>Surface Area = Ï€ * Radius * (Radius + Height)<br>Volume = (1/3) * Ï€ * Radius^2 * Height</html>");
                break;
        }
    }

    // Method to set editable fields based on selected shape
    public void setFieldsEditable(String shape) {
        lengthField.setEditable(false);
        widthField.setEditable(false);
        radiusField.setEditable(false);
        baseField.setEditable(false);
        heightField.setEditable(false);

        switch (shape) {
            case "circle":
                radiusField.setEditable(true);
                break;
            case "rectangle":
                lengthField.setEditable(true);
                widthField.setEditable(true);
                break;
            case "triangle":
                baseField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "sphere":
                radiusField.setEditable(true);
                break;
            case "cube":
                lengthField.setEditable(true);
                break;
            case "cylinder":
                radiusField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "cuboid":
                lengthField.setEditable(true);
                widthField.setEditable(true);
                heightField.setEditable(true);
                break;
            case "cone":
                radiusField.setEditable(true);
                heightField.setEditable(true);
                break;
        }
    }

    // Method to clear all input fields
    public void clearFields() {
        lengthField.setText("");
        widthField.setText("");
        radiusField.setText("");
        baseField.setText("");
        heightField.setText("");
    }

    // Checks if required inputs are missing for calculating surface area based on the current shape.
    private boolean areInputsMissingForSurfaceArea() {
        switch (currentShape) {
            case "circle":
                return radiusField.getText().isEmpty();
            case "rectangle":
                return lengthField.getText().isEmpty() || widthField.getText().isEmpty();
            case "triangle":
                return baseField.getText().isEmpty() || heightField.getText().isEmpty();
            case "sphere":
                return radiusField.getText().isEmpty();
            case "cube":
                return lengthField.getText().isEmpty();
            case "cylinder":
                return radiusField.getText().isEmpty() || heightField.getText().isEmpty();
            case "cuboid":
                return lengthField.getText().isEmpty() || widthField.getText().isEmpty() || heightField.getText().isEmpty();
            case "cone":
                return radiusField.getText().isEmpty() || heightField.getText().isEmpty();
            default:
                return true;
        }
    }

    // Checks if required inputs are missing for calculating volume based on the current shape.
    private boolean areInputsMissingForVolume() {
        switch (currentShape) {
            case "circle":
            case "rectangle":
            case "triangle":
                return true; // Volume calculation is not applicable for 2D shapes
            case "sphere":
                return radiusField.getText().isEmpty();
            case "cube":
                return lengthField.getText().isEmpty();
            case "cylinder":
                return radiusField.getText().isEmpty() || heightField.getText().isEmpty();
            case "cuboid":
                return lengthField.getText().isEmpty() || widthField.getText().isEmpty() || heightField.getText().isEmpty();
            case "cone":
                return radiusField.getText().isEmpty() || heightField.getText().isEmpty();
            default:
                return true;
        }
    }

    // Performs calculation based on the selected operation (surface area or volume).
    private void performCalculation(String operation) {
        if (currentShape == null) {
            JOptionPane.showMessageDialog(this, "Please select a shape first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (operation.contains("volume") && (currentShape.equals("circle") || currentShape.equals("rectangle") || currentShape.equals("triangle"))) {
                JOptionPane.showMessageDialog(this, "Volume calculation is not applicable for 2D shapes.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (operation.contains("surface") && areInputsMissingForSurfaceArea()) {
                JOptionPane.showMessageDialog(this, "Please enter all required fields for surface area calculation.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (operation.contains("volume") && areInputsMissingForVolume()) {
                JOptionPane.showMessageDialog(this, "Please enter all required fields for volume calculation.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double radius = !radiusField.getText().isEmpty() ? Double.parseDouble(radiusField.getText()) : 0;
            double length = !lengthField.getText().isEmpty() ? Double.parseDouble(lengthField.getText()) : 0;
            double width = !widthField.getText().isEmpty() ? Double.parseDouble(widthField.getText()) : 0;
            double base = !baseField.getText().isEmpty() ? Double.parseDouble(baseField.getText()) : 0;
            double height = !heightField.getText().isEmpty() ? Double.parseDouble(heightField.getText()) : 0;

            Shape shape;
            switch (currentShape) {
                case "circle":
                    shape = new Circle(radius);
                    break;
                case "rectangle":
                    shape = new Rectangle(length, width);
                    break;
                case "triangle":
                    shape = new Triangle(base, height);
                    break;
                case "sphere":
                    shape = new Sphere(radius);
                    break;
                case "cube":
                    shape = new Cube(length);
                    break;
                case "cylinder":
                    shape = new Cylinder(radius, height);
                    break;
                case "cuboid":
                    shape = new Cuboid(length, width, height);
                    break;
                case "cone":
                    shape = new Cone(radius, height);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape: " + currentShape);
            }

            double result;
            String unit;

            if (operation.contains("surface")) {
                result = shape.calculateSurfaceArea();
                unit = " cmÂ²";
            } else {
                if (!shape.isVolumeApplicable()) {
                    JOptionPane.showMessageDialog(this, "Volume calculation is not applicable for this shape.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = shape.calculateVolume();
                unit = " cmÂ³";
            }

            displayArea.append(String.format("%s %s = %.2f%s%n", currentShape, operation.contains("surface") ? "Surface Area" : "Volume", result, unit));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Sets the current shape selected by the user.
    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }

    // ActionListener implementation to save the data from the display area to a file.
    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("geometry_data.txt"))) {
                out.writeObject(displayArea.getText());
                displayArea.append("Data saved successfully.\n");
            } catch (IOException ex) {
                displayArea.append("Error saving data: " + ex.getMessage() + "\n");
            }
        }
    }

    // ActionListener that loads data from "geometry_data.txt" file into displayArea.
    private class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("geometry_data.txt"))) {
                String data = (String) in.readObject();
                displayArea.append("Loaded data:\n" + data);
            } catch (IOException | ClassNotFoundException ex) {
                displayArea.append("Error loading data: " + ex.getMessage() + "\n");
            }
        }
    }
}
