package Question1;

import java.util.Scanner;

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        if (width < 0) {
            System.out.println("Warning: input width is negative!");
            this.width = 1;
        } else {
            this.width = width;
        }

        if (height < 0) {
            System.out.println("Warning: input height is negative!");
            this.height = 1;
        } else {
            this.height = height;
        }

    }

    public void visualize(int width, int height) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print("*");
            }
        }

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

}


public class Question1 {
    public static void main(String[] args) {
        System.out.println("Test");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter width: ");
            int width = scanner.nextInt();
            System.out.print("Enter height: ");
            int height = scanner.nextInt();
            Rectangle rectangle = new Rectangle(width, height);
            rectangle.visualize(width, height);
        }
        scanner.close();
    }

}
