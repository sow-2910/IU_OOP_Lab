package question3;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person[name= " + name + ",address= " + address + "]";
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString() + ",program= " + program + ",year= " + year + ",fee= " + fee;
    }
}

class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + ",school= " + school + ",pay= " + pay;
    }
}

public class question3 {
    public static void main(String[] args) {
        System.out.println("Test Person");
        Person person = new Person("An", "Hanoi");
        System.out.println(person.toString());

        person.setAddress("Ho Chi Minh City");
        System.out.println("Updated Address: " + person.getAddress());
        System.out.println("Name: " + person.getName());
        System.out.println(person);
        System.out.println("----------------------");

        System.out.println("Test Student");
        Student student = new Student("Binh", "Da Nang", "Computer Science", 2, 1500.0);
        System.out.println(student.toString());
        student.setProgram("AI Engineering");
        student.setYear(3);
        student.setFee(2000.0);
        student.setAddress("Hue");
        System.out.println("Updated Program: " + student.getProgram());
        System.out.println("Updated Year: " + student.getYear());
        System.out.println("Updated Fee: " + student.getFee());
        System.out.println("Updated Address: " + student.getAddress());
        System.out.println(student);
        System.out.println("----------------------");

        System.out.println("Test Staff");
        Staff staff = new Staff("Chi", "Hanoi", "HCM University", 3000.0);
        System.out.println(staff.toString());

        staff.setSchool("Da Nang University");
        staff.setPay(3500.0);
        staff.setAddress("Da Nang");
        System.out.println("Updated School: " + staff.getSchool());
        System.out.println("Updated Pay: " + staff.getPay());
        System.out.println("Updated Address: " + staff.getAddress());
        System.out.println(staff);
        System.out.println("----------------------");
    }

}
