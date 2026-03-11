package entity;

import util.Validation;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    /**
     * Creates a Triangle with the given side lengths, validated for the triangle inequality.
     *
     * @param sideA the length of side A (must be > 0)
     * @param sideB the length of side B (must be > 0)
     * @param sideC the length of side C (must be > 0)
     * @throws IllegalArgumentException if any side is not positive or the sides do not form a valid triangle
     */
    public Triangle(double sideA, double sideB, double sideC) {
        setSideA(sideA);
        setSideB(sideB);
        setSideC(sideC);
        if (!Validation.isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Invalid triangle: sides do not satisfy triangle inequality.");
        }
    }

    /**
     * @return the length of side A
     */
    public double getSideA() {
        return sideA;
    }

    /**
     * @return the length of side B
     */
    public double getSideB() {
        return sideB;
    }

    /**
     * @return the length of side C
     */
    public double getSideC() {
        return sideC;
    }

    /**
     * @param sideA the length of side A to set
     * @throws IllegalArgumentException if sideA is not greater than 0
     */
    public void setSideA(double sideA) {
        if (!Validation.isValidDimension(sideA)) {
            throw new IllegalArgumentException("Side A must be greater than 0.");
        }
        this.sideA = sideA;
    }

    /**
     * @param sideB the length of side B to set
     * @throws IllegalArgumentException if sideB is not greater than 0
     */
    public void setSideB(double sideB) {
        if (!Validation.isValidDimension(sideB)) {
            throw new IllegalArgumentException("Side B must be greater than 0.");
        }
        this.sideB = sideB;
    }

    /**
     * @param sideC the length of side C to set
     * @throws IllegalArgumentException if sideC is not greater than 0
     */
    public void setSideC(double sideC) {
        if (!Validation.isValidDimension(sideC)) {
            throw new IllegalArgumentException("Side C must be greater than 0.");
        }
        this.sideC = sideC;
    }

    /**
     * Calculates the perimeter of the triangle.
     *
     * @return sideA + sideB + sideC
     */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     *
     * @return the area computed from the semi-perimeter and three sides
     */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    /**
     * Prints the triangle's sides, area, and perimeter to the console.
     */
    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());
    }
}
