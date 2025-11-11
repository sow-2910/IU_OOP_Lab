package question3b;

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public String toString() {
        return "ResizableCircle[" + super.toString() + "]";
    }

    @Override
    public double resize(int percent) {
        // percent = 80 nghĩa là giữ 80% kích thước ban đầu
        radius = radius * (percent / 100.0);
        return radius;
    }
}
