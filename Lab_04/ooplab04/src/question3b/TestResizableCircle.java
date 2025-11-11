package question3b;

public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle rc1 = new ResizableCircle(100);
        // Hiện thông tin ban đầu
        System.out.println(rc1.toString());
        System.out.println("Area: " + rc1.getArea());
        System.out.println("Perimeter: " + rc1.getPerimeter());

        // Resize xuống 80% (giảm còn 80%)
        rc1.resize(80);

        // Hiện thông tin sau khi resize
        System.out.println("After resize to 80%:");
        System.out.println(rc1.toString());
        System.out.println("Area: " + rc1.getArea());
        System.out.println("Perimeter: " + rc1.getPerimeter());
    }
}
