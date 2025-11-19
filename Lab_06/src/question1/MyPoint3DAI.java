// File: MyPoint3DAI.java
public class MyPoint3DAI {
    private double x;
    private double y;
    private double z;

    public MyPoint3DAI(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Setters (giữ lại để hoàn chỉnh, nhưng cần thận trọng khi sử dụng)
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}