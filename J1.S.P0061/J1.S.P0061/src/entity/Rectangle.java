package entity;

import util.Validation;

public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    /**
     * Creates a Rectangle with the given width and length.
     *
     * @param width  the width of the rectangle (must be > 0)
     * @param length the length of the rectangle (must be > 0)
     * @throws IllegalArgumentException if width or length is not positive
     */
    public Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the length of the rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * @param width the width to set
     * @throws IllegalArgumentException if width is not greater than 0
     */
    public void setWidth(double width) {
        if (!Validation.isValidDimension(width)) {
            throw new IllegalArgumentException("Width must be greater than 0.");
        }
        this.width = width;
    }

    /**
     * @param length the length to set
     * @throws IllegalArgumentException if length is not greater than 0
     */
    public void setLength(double length) {
        if (!Validation.isValidDimension(length)) {
            throw new IllegalArgumentException("Length must be greater than 0.");
        }
        this.length = length;
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return 2 * (width + length)
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return width * length
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * Prints the rectangle's dimensions, area, and perimeter to the console.
     */
    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
