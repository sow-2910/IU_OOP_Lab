import java.util.Scanner;

public class Lab6Ex1 {

    public static int getVolume(MyCuboid p1, MyCuboid p2) {
        int lengthX = Math.abs(p1.getVertex1().getX() - p2.getVertex2().getX());
        int lengthY = Math.abs(p1.getVertex1().getY() - p2.getVertex2().getY());
        int lengthZ = Math.abs(p1.getVertex1().getZ() - p2.getVertex2().getZ());

        return lengthX * lengthY * lengthZ;
    }

    public static MyPoint3D readPoint3D(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        return new MyPoint3D(x, y, z);
    }

    public static MyCuboid readCuboid(Scanner sc) {
        MyPoint3D p1 = readPoint3D(sc);
        MyPoint3D p2 = readPoint3D(sc);

        return new MyCuboid(p1, p2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st cuboid: ");
        MyCuboid cuboid1 = readCuboid(scanner);

        System.out.print("Enter 2nd cuboid: ");
        MyCuboid cuboid2 = readCuboid(scanner);

        int volume = getVolume(cuboid1, cuboid2);

        System.out.println("1st cuboid: " + cuboid1.toString());
        System.out.println("2nd cuboid: " + cuboid2.toString());
        System.out.println("Volume of common space = " + volume);

    }
}