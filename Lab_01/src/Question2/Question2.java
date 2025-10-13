package Question2;

import java.util.Scanner;

class Triangle {
    private int x;
    private int y;
    private int z;

    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public String verify(int x, int y, int z) {
        if (x + y < z || x + z < y || y + z < x) {
            return "Not triangle";
        } else if (x == y && y == z) {
            return "Equilateral";
        } else if (x == y || x == z || y == z) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}


public class Question2 {
    public static void main(String[] args) {
        System.out.println("Test");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three sides of the triangle:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        Triangle triangle = new Triangle(x, y, z);
        System.out.printf("The sides of the triangle is: %d %d %d", triangle.getX(), triangle.getY(), triangle.getZ());
        System.out.println(triangle.verify(x, y, z));
        scanner.close();
    }
}
