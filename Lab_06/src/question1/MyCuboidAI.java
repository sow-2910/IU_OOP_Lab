
// File: MyCuboidAI.java


public class MyCuboidAI {
    private MyPoint3DAI Vertex1; // Luôn là (xmin, ymin, zmin)
    private MyPoint3DAI Vertex2; // Luôn là (xmax, ymax, zmax)

    public MyCuboidAI() {
        // Constructor mặc định
    }

    /**
     * Constructor với logic CHUẨN HÓA tọa độ
     * Đảm bảo Vertex1 là min/min/min và Vertex2 là max/max/max.
     */
    public MyCuboidAI(MyPoint3DAI vertexA, MyPoint3DAI vertexB) {
        // 1. Chuẩn hóa và tạo bản sao đối tượng
        double xmin = Math.min(vertexA.getX(), vertexB.getX());
        double ymin = Math.min(vertexA.getY(), vertexB.getY());
        double zmin = Math.min(vertexA.getZ(), vertexB.getZ());

        double xmax = Math.max(vertexA.getX(), vertexB.getX());
        double ymax = Math.max(vertexA.getY(), vertexB.getY());
        double zmax = Math.max(vertexA.getZ(), vertexB.getZ());

        this.Vertex1 = new MyPoint3DAI(xmin, ymin, zmin);
        this.Vertex2 = new MyPoint3DAI(xmax, ymax, zmax);
    }

    /**
     * Phương thức tính thể tích của CHÍNH hình hộp này (KHÔNG nhận tham số).
     * Nhờ có chuẩn hóa, ta không cần Math.abs().
     */
    public double getVolume() {
        // Chiều dài = Max - Min. (Luôn dương nhờ đã chuẩn hóa)
        double lengthX = this.Vertex2.getX() - this.Vertex1.getX();
        double lengthY = this.Vertex2.getY() - this.Vertex1.getY();
        double lengthZ = this.Vertex2.getZ() - this.Vertex1.getZ();

        // Đảm bảo thể tích không âm
        if (lengthX <= 0 || lengthY <= 0 || lengthZ <= 0) {
            return 0.0;
        }

        return lengthX * lengthY * lengthZ;
    }

    // Getters để truy cập các giới hạn Min/Max
    public double getXmin() {
        return Vertex1.getX();
    }

    public double getXmax() {
        return Vertex2.getX();
    }

    public double getYmin() {
        return Vertex1.getY();
    }

    public double getYmax() {
        return Vertex2.getY();
    }

    public double getZmin() {
        return Vertex1.getZ();
    }

    public double getZmax() {
        return Vertex2.getZ();
    }

    // Getters trả về đối tượng MyPoint3DAI (đã chuẩn hóa)
    public MyPoint3DAI getVertex1() {
        return Vertex1;
    }

    public MyPoint3DAI getVertex2() {
        return Vertex2;
    }

    @Override
    public String toString() {
        return "[ (" + getXmin() + "," + getYmin() + "," + getZmin() + ") ; (" + getXmax() + "," + getYmax() + ","
                + getZmax() + ") ]";
    }
}