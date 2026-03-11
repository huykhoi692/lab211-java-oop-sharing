package entity;

import util.Validation;

public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    /**
     * Creates a Circle with the given radius.
     *
     * @param radius the radius of the circle (must be > 0)
     * @throws IllegalArgumentException if radius is not positive
     */
    public Circle(double radius) {
        setRadius(radius);
    }

    /**
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     * @throws IllegalArgumentException if radius is not greater than 0
     */
    public void setRadius(double radius) {
        if (!Validation.isValidDimension(radius)) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    /**
     * Calculates the perimeter (circumference) of the circle.
     *
     * @return 2 * PI * radius
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return PI * radius * radius
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Prints the circle's radius, area, and perimeter to the console.
     */
    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());
    }
}
