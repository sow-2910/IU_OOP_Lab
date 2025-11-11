package question4;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("E01", "Trần Thành Phát", 25, 0, 7);
        Employee employee2 = new Employee("E02", "Nguyễn Thành Phát", 20, 2, 5);
        Employee employee3 = new Employee("E03", "Lưu Gia Huy", 21, 3, 4);
        Employee employee4 = new Employee("E04", "Ngô Đa Lộc", 23, 4, 3);
        Employee employee5 = new Employee("E05", "Lê Duy Quốc Bảo", 24, 0, 7);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Project OOP = new Project("OOP1", sdf.parse("29-10-2025"), sdf.parse("29-11-2025"));
            OOP.addEmployees(employee1, employee2, employee3, employee4, employee5);

            System.out.println(OOP.getProjectId());
            System.out.println("Before sorting:");
            for (Employee e : OOP.getEmployees()) {
                System.out.println(e);
            }
            OOP.sortEmployees();
            System.out.println("After sorting:");
            for (Employee e : OOP.getEmployees()) {
                System.out.println(e);
            }

            // for (Employee e : OOP.getEmployees()) {
            // System.out.println(e.toString());
            // }
            System.out.printf("Estimated Budget: %d\n", OOP.estimateBudget());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
