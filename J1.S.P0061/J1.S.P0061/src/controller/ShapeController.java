package controller;

import entity.Circle;
import entity.Rectangle;
import entity.Triangle;
import util.Validation;

import java.util.Scanner;

public class ShapeController {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads all shape dimensions from the user, then calculates and prints results for each shape.
     */
    public void run() {
        System.out.println("=====Calculator Shape Program=====");

        double width  = readDimension("Please input side width of Rectangle: ");
        double length = readDimension("Please input length of Rectangle: ");
        double radius = readDimension("Please input radius of Circle: ");

        double sideA;
        double sideB;
        double sideC;
        while (true) {
            sideA = readDimension("Please input side A of Triangle: ");
            sideB = readDimension("Please input side B of Triangle: ");
            sideC = readDimension("Please input side C of Triangle: ");
            if (Validation.isValidTriangle(sideA, sideB, sideC)) {
                break;
            }
            System.out.println("Invalid triangle sides. Please re-enter.");
        }

        Rectangle rect = new Rectangle(width, length);
        rect.printResult();

        Circle circle = new Circle(radius);
        circle.printResult();

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        triangle.printResult();
    }

    /**
     * Prompts the user repeatedly until a valid positive number is entered.
     *
     * @param prompt the message to display before reading input
     * @return the parsed positive double value entered by the user
     */
    private double readDimension(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (Validation.isValidDimensionStr(input)) {
                return Double.parseDouble(input);
            }
            System.out.println("Value must be a number greater than 0. Please re-enter.");
        }
    }
}
