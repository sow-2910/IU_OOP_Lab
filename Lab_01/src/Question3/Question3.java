package Question3;

import java.util.Scanner;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point target) {
        double delta_x = this.x - target.x;
        double delta_y = this.y - target.y;
        return Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));
    }
}


public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first point x and y: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Point first = new Point(x1, y1);

        System.out.println("Enter the second point x and y: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Point second = new Point(x2, y2);

        double result = first.distance(second);
        System.out.printf("The distance between the first point and the second point is: %.2f",
                result);
        scanner.close();
    }
}
