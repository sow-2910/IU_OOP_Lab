
// File: Lab6_ex1_AI.java
import java.util.Scanner;

public class Lab6_ex1_AI {

    // (Lưu ý: Nếu không dùng nested class, bạn phải đảm bảo MyPoint3DAI và
    // MyCuboidAI
    // nằm trong các file riêng biệt hoặc nằm ngoài class Lab6_ex1_AI)

    // ----------------------------------------------------
    // Phương thức hỗ trợ: Đọc 3 giá trị (x, y, z)
    // ----------------------------------------------------
    public static MyPoint3DAI readPoint3D(Scanner sc) {
        // Đọc 3 tọa độ (x, y, z)
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        return new MyPoint3DAI(x, y, z);
    }

    // ----------------------------------------------------
    // Phương thức đọc MyCuboid (Đọc 2 điểm, tạo 1 Cuboid)
    // ----------------------------------------------------
    public static MyCuboidAI readCuboid(Scanner sc) {
        // Đọc 3 tọa độ cho P1
        MyPoint3DAI p1 = readPoint3D(sc);
        // Đọc 3 tọa độ cho P2
        MyPoint3DAI p2 = readPoint3D(sc);

        // Trả về MyCuboidAI mới (sẽ tự động chuẩn hóa)
        return new MyCuboidAI(p1, p2);
    }

    // ----------------------------------------------------
    // Phương thức tính thể tích chung (Sử dụng Min/Max)
    // ----------------------------------------------------
    public static double commonVolume(MyCuboidAI c1, MyCuboidAI c2) {

        // Chiều dài trục X giao nhau
        double common_xmin = Math.max(c1.getXmin(), c2.getXmin());
        double common_xmax = Math.min(c1.getXmax(), c2.getXmax());
        double length_x = Math.max(0, common_xmax - common_xmin);

        // Chiều dài trục Y giao nhau
        double common_ymin = Math.max(c1.getYmin(), c2.getYmin());
        double common_ymax = Math.min(c1.getYmax(), c2.getYmax());
        double length_y = Math.max(0, common_ymax - common_ymin);

        // Chiều dài trục Z giao nhau
        double common_zmin = Math.max(c1.getZmin(), c2.getZmin());
        double common_zmax = Math.min(c1.getZmax(), c2.getZmax());
        double length_z = Math.max(0, common_zmax - common_zmin);

        // Thể tích chung
        return length_x * length_y * length_z;
    }

    // ----------------------------------------------------
    // Hàm main (Thực thi)
    // ----------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc Cuboid 1
        System.out.print("Enter 1st cuboid: ");
        MyCuboidAI cuboid1 = readCuboid(sc);

        // Đọc Cuboid 2
        System.out.print("Enter 2nd cuboid: ");
        MyCuboidAI cuboid2 = readCuboid(sc);

        // Tính và in kết quả
        double volume = commonVolume(cuboid1, cuboid2);

        System.out.print("1st cuboid: ");
        System.out.println(cuboid1);

        System.out.print("2nd cuboid: ");
        System.out.println(cuboid2);

        // Dùng %.0f để in ra số nguyên (40) như output mẫu
        System.out.printf("Volume of common space = %.0f\n", volume);
    }
}