package question1;

public class MyCuboid {
    private MyPoint3D Vertex1;
    private MyPoint3D Vertex2;

    public MyCuboid() {

    }

    public MyCuboid(MyPoint3D vertex1, MyPoint3D vertex2) {
        int xMin = Math.min(vertex1.getX(), vertex2.getX());
        int yMin = Math.min(vertex1.getY(), vertex2.getY());
        int zMin = Math.min(vertex1.getZ(), vertex2.getZ());

        int xMax = Math.max(vertex1.getX(), vertex2.getX());
        int yMax = Math.max(vertex1.getY(), vertex2.getY());
        int zMax = Math.max(vertex1.getZ(), vertex2.getZ());
        this.Vertex1 = new MyPoint3D(xMin, yMin, zMin);
        this.Vertex2 = new MyPoint3D(xMax, yMax, zMax);
    }

    public MyPoint3D getVertex1() {
        return Vertex1;
    }

    public void setVertex1(MyPoint3D vertex1) {
        Vertex1 = vertex1;
    }

    public MyPoint3D getVertex2() {
        return Vertex2;
    }

    public void setVertex2(MyPoint3D vertex2) {
        Vertex2 = vertex2;
    }

    public int getXmin() {
        return Vertex1.getX();
    }

    public int getXmax() {
        return Vertex2.getX();
    }

    public int getYmin() {
        return Vertex1.getY();
    }

    public int getYmax() {
        return Vertex2.getY();
    }

    public int getZmin() {
        return Vertex1.getZ();
    }

    public int getZmax() {
        return Vertex2.getZ();
    }

    @Override
    public String toString() {
        return "[ (" + getVertex1() + ") ; (" + getVertex2() + ") ]";
    }

}
