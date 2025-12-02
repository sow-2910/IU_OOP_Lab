public class Main {
    public static void main(String[] args) {
        Shape c1 = new Circle(5);
        Shape s1 = new Square(4);
        Shape t1 = new Triangle(12, 10);
        Shape[] myShapes = { c1, s1, t1 };

        AreaCalculator calculator = new AreaCalculator();
        double total = calculator.totalArea(myShapes);

        System.out.println("The total area of all shapes in the array is: " + total);
        // This follow OCP since when i add the triangle class, i does not need to
        // change the original code
    }
}
