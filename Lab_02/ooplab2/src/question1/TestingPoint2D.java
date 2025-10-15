package question1;

import java.util.Scanner;

class Point2D {
    private int x;
    private int y;
    Scanner scanner = new Scanner(System.in);

    public Point2D() {
        x = 0;
        y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void input() {
        System.out.println("Enter X: ");
        int x = scanner.nextInt();
        this.x = x;
        System.out.println("Enter Y: ");
        int y = scanner.nextInt();
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public void move(int x, int y) {

    }

    public boolean isOrigin() {
        if (x == 0 && y == 0)
            return true;
        else
            return false;
    }

    public double distance(Point2D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        double result = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return result;
    }

    public static double distance(Point2D p1, Point2D p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        double result = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return result;
    }

}

public class TestingPoint2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point2D p1 = new Point2D();
        System.out.printf("The initial value of p1: %s\n", p1);
        System.out.printf("Is p1 at the origin?: %s\n", p1.isOrigin());
        System.out.println("Asking user to change values for p1!");
        p1.input();
        System.out.printf("The new value of p1: %s\n", p1);
        System.out.println("Enter X and Y of p2:");
        Point2D p2 = new Point2D(scanner.nextInt(), scanner.nextInt());
        System.out.printf("The value of p2: %s\n", p2);
        Point2D p3 = new Point2D(p2);
        System.out.printf("The value of p3: %s\n", p3);
        System.out.printf("First way to calculate distance between p1 and p2: %.2f\n", p1.distance(p2));
        System.out.printf("Second way to calculate distance between p1 and p2: %.2f\n", Point2D.distance(p1, p2));
        System.out.printf("First way to calculate distance between p2 and p3: %.2f\n", p2.distance(p3));
        System.out.printf("Second way to calculate distance between p2 and p3: %.2f\n", Point2D.distance(p2, p3));
        scanner.close();
    }
}
