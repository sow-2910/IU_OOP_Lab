package question2;

import java.awt.geom.Point2D;
import java.util.*;

public class Lab6Ex2 {

    public static void overlapCheck(MyRectangle rec1, MyRectangle rec2) {
        double xMin = Math.max(rec1.getXmin(), rec2.getXmin());
        double yMin = Math.max(rec1.getYmin(), rec2.getYmin());

        double xMax = Math.min(rec1.getXmax(), rec2.getXmax());
        double yMax = Math.min(rec1.getYmax(), rec2.getYmax());

        if (xMin < xMax && yMin < yMax) {
            System.out.println("The two rectangle overlap");

            double deltaX = xMax - xMin;
            double deltaY = yMax - yMin;
            double area = deltaX * deltaY;

            System.out.println("The area of the 2 rectangle is: " + area);
        } else {
            boolean isDisjoint = (rec1.getXmax() < rec2.getXmin()) || (rec1.getXmin() < rec2.getXmax())
                    || (rec1.getYmax() < rec2.getYmin()) || (rec1.getYmin() > rec2.getYmax());

            if (isDisjoint) {
                System.out.println("The two rectangle are disjoint");
            } else {
                System.out.println("The two rectangle are touch");
            }
        }
    }

    public static Point2D.Double readPoint2Double(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Point2D.Double(x, y);
    }

    public static MyRectangle readRectangle(Scanner sc) {
        Point2D.Double pt1 = readPoint2Double(sc);
        Point2D.Double pt2 = readPoint2Double(sc);
        return new MyRectangle(pt1, pt2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first rectangle");
        MyRectangle rec1 = readRectangle(scanner);

        System.out.println("Enter second rectangle");
        MyRectangle rec2 = readRectangle(scanner);

        System.out.println(rec1.toString());
        System.out.println(rec2.toString());

        overlapCheck(rec1, rec2);

        scanner.close();

    }
}