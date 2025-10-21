package question2;

import question1.Point2D;

import java.util.Scanner;

class Triangle {
    private Point2D p1;
    private Point2D p2;
    private Point2D p3;

    public Triangle(Point2D p1, Point2D p2, Point2D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

    }

    public double perimeter() {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p1.distance(p3);
        double perimeter = side1 + side2 + side3;
        return perimeter;
    }

    public double area() {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p1.distance(p3);
        double p = perimeter() / 2;
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }
}

public class TriangleTesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(2, 7);
        Point2D p3 = new Point2D(3, 4);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.printf("The perimeter is %.2f\n", triangle.perimeter());
        System.out.printf("The area is %.2f\n", triangle.area());
        scanner.close();
    }
}
