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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}


public class Question1 {
    public static void main(String[] args) {
        System.out.println("Test");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter width and height: ");
            Rectangle rect = new Rectangle(scanner.nextInt(), scanner.nextInt());
            rect.visualize(rect.getWidth(), rect.getHeight());
        }
        scanner.close();
    }

}
