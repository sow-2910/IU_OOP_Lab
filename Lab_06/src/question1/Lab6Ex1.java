package question1;

import java.util.Scanner;

public class Lab6Ex1 {

    public static int getVolume(MyCuboid p1, MyCuboid p2) {
        int xminforVolume = Math.max(p1.getXmin(), p2.getXmin());
        int xmaxforVolume = Math.min(p1.getXmax(), p2.getXmax());
        int lengthX = Math.max(0, xmaxforVolume - xminforVolume);

        int yminforVolume = Math.max(p1.getYmin(), p2.getYmin());
        int ymaxforVolume = Math.min(p1.getYmax(), p2.getYmax());
        int lengthY = Math.max(0, ymaxforVolume - yminforVolume);

        int zminforVolume = Math.max(p1.getZmin(), p2.getZmin());
        int zmaxforVolume = Math.min(p1.getZmax(), p2.getZmax());
        int lengthZ = Math.max(0, zmaxforVolume - zminforVolume);

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