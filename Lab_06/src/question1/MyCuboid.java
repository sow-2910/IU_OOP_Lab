
public class MyCuboid {
    private MyPoint3D Vertex1;
    private MyPoint3D Vertex2;

    public MyCuboid() {

    }

    public MyCuboid(MyPoint3D vertex1, MyPoint3D vertex2) {
        this.Vertex1 = vertex1;
        this.Vertex2 = vertex2;
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

    @Override
    public String toString() {
        return "[ (" + getVertex1() + ") ; (" + getVertex2() + ") ]";
    }

}
