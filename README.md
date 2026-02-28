# Geometry Calculator Application

## Original Author  
This project is created and maintained by 

- **Akmal Hakimi bin Abd Rashid**  
- **Muhammad Irfan Mikael bin Radzuan**
<u>[Chan Boon Hong](https://github.com/mrnothing00)</u>
- **Muhammad Haziq Haikal bin Hasmi**

---

## Introduction  
**Geometry Calculator Application** is a Java-based GUI application developed as part of the **ISB16003 - Object Oriented Programming** course at **Universiti Kuala Lumpur (UniKL)** for the June 2024 session. This project was completed under the supervision of:

- **Course Lecturer**: Dr. Juliana Jaafar

The application is designed to help users calculate the surface area and volume of various 2D and 3D geometric shapes using Java’s Swing framework. It also integrates basic file operations and validation for a complete user experience.

---

## Problem Statements & Objectives

### Problem Statements
- **Manual Geometry Calculations**: Users often find it tedious to calculate surface area or volume manually, especially for 3D shapes.
- **Inconsistent Inputs**: Input errors lead to incorrect calculations or confusion, especially with invalid numeric entries.
- **Need for Learning Tool**: A graphical, interactive tool can support both learners and casual users in understanding geometric computations.

### Objectives
- Implement GUI-based calculator for geometric shapes
- Apply OOP concepts such as inheritance, polymorphism, and encapsulation
- Provide surface area and volume calculations for both 2D and 3D shapes
- Allow users to **save** and **load** previous calculations
- Introduce **shortcut keys** for quicker navigation
- Handle invalid inputs and missing fields gracefully with error popups

---

## Program Scope  

This project is structured into several functional components:

### 📐 2D Shape Calculations
- **Supported Shapes**: Circle, Rectangle, Triangle
- **Functionality**: Surface area only
- **Shortcuts**:
  - Circle: Ctrl+1  
  - Rectangle: Ctrl+2  
  - Triangle: Ctrl+3  

![2D Shape Screenshot](https://github.com/user-attachments/assets/084bbd8f-9850-4099-9757-37810049916d)

---

### 📦 3D Shape Calculations
- **Supported Shapes**: Sphere, Cube, Cylinder, Cuboid, Cone
- **Functionality**: Surface area and volume
- **Shortcuts**:
  - Sphere: Ctrl+4  
  - Cube: Ctrl+5  
  - Cylinder: Ctrl+6  
  - Cuboid: Ctrl+7  
  - Cone: Ctrl+8  

![3D Shape Screenshot](https://github.com/user-attachments/assets/a46dffc6-7c42-40b6-bbdd-584d3b859b42)

---

### 💾 Save & Load
- Users can save calculation results to a file
- Load previously saved results back into the app
- **Shortcuts**:
  - Save: Ctrl+S  
  - Load: Ctrl+L  

![Save and Load Screenshot](https://github.com/user-attachments/assets/fa56d239-fac5-4215-8b05-cf8088630160)

---

### ❌ Exit Options
- Users may click the “Exit” button or close the window directly (via X icon)

![Exit Screenshot](https://github.com/user-attachments/assets/2f019e07-0312-45f8-bf32-4d442b3e6919)

---

## Error Handling

The application includes comprehensive popup-based error checking for:
- Not selecting a shape
- Entering non-numeric values
- Leaving required fields empty
- Attempting volume calculations on 2D shapes

---

## UML Design

The application follows a clean OOP design pattern:
- Separate classes for 2D and 3D shapes
- Inheritance for shared functionality
- Encapsulated data validation and calculation logic

---



## Conclusion

The **Geometry Calculator Application** combines mathematical computations with strong object-oriented programming practices. Through this mini project, students gain experience in:
- GUI development using Swing
- Java file handling
- Real-time input validation
- Applying inheritance and polymorphism
