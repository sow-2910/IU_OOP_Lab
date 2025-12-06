import java.util.*;

interface INotifier {
    void sendNoti(Student s, String message);
}

interface IEnrollmentRule {
    boolean validate(Student s, Course c);
}

interface IEnrollmentRepository {
    void save(Student s, Course c);
}

class Student {
    public String name;
    public String email;
    public int phoneNumber;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

class Course {
    public String name;
    public String id;
    public int capacity; // capacity of the course
    public int currentEnrolled;
    public Set<String> enrolledStudentsIds;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.currentEnrolled = 0;
    }
}

class EmailNotifier implements INotifier {
    @Override
    public void sendNoti(Student s, String message) {
        System.out.println("Email sent to " + s.email + ": " + message);
    }
}

class SmsNotifier implements INotifier {
    @Override
    public void sendNoti(Student s, String message) {
        System.out.println("Sms sent to " + s.phoneNumber + ": " + message);
    }
}

class MaxSizeRule implements IEnrollmentRule {
    @Override
    public boolean validate(Student s, Course c) {
        if (c.currentEnrolled >= c.capacity) {
            System.out.println("Error: Course  " + c.name + " is full");
            return false;
        }
        return true;
    }
}

class DuplicateEnrollmentRule implements IEnrollmentRule {
    @Override
    public boolean validate(Student s, Course c) {
        if (c.enrolledStudentsIds.contains(s.email)) {
            System.out.println("Student: " + s.name + " is already enrolled the Course: " + c.name);
            return false;
        }
        return true;
    }
}

class Repository implements IEnrollmentRepository {
    @Override
    public void save(Student s, Course c) {
        c.currentEnrolled++;
        System.out.println("Saved Enrollemnt for " + s.name + " in course: " + c.name);
        c.enrolledStudentsIds.add(s.email);
    }
}

class EnrollmentService {

    private final IEnrollmentRepository repository;
    private final List<IEnrollmentRule> rules;
    private final INotifier notifer;

    public EnrollmentService(IEnrollmentRepository repo, INotifier noti) {
        this.repository = repo;
        this.notifer = noti;
        this.rules = new ArrayList<>();
    }

    public void addRule(IEnrollmentRule rule) {
        this.rules.add(rule);
    }

    public void enroll(Student s, Course c) {
        System.out.println("Processing enrollment for: " + s.name);

        for (IEnrollmentRule rule : rules) {
            if (!rule.validate(s, c)) {
                System.out.println("Course Enrolled failed");
                return;
            }
        }

        repository.save(s, c);

        notifer.sendNoti(s, "Welcome to course" + c.name);
    }

}

public class Main {
    public static void main(String[] args) {

        // Email repo
        IEnrollmentRepository myRepo = new Repository();

        INotifier myNotifier = new EmailNotifier();

        EnrollmentService service = new EnrollmentService(myRepo, myNotifier);

        service.addRule(new MaxSizeRule());
        service.addRule(new DuplicateEnrollmentRule());

        Course oopCourse = new Course("OOP", 3);
        Student st1 = new Student("Phat", "Phat@gmail.com");
        Student st2 = new Student("Lon", "Lon@gmail.com");
        Student st3 = new Student("Huy", "Huy@gmail.com");
        Student st4 = new Student("Hoang", "Hoang@gmail.com");
        Student st5 = new Student("Hoa", "Hoa@gmail.com");

        service.enroll(st1, oopCourse);
        service.enroll(st2, oopCourse);
        service.enroll(st3, oopCourse);
        service.enroll(st4, oopCourse);
        service.enroll(st5, oopCourse);

        System.out.println("--------------------------");

        // Sms repo
        IEnrollmentRepository smsRepo = new Repository();

        INotifier myNotifier1 = new SmsNotifier();

        EnrollmentService service1 = new EnrollmentService(smsRepo, myNotifier1);

        service.addRule(new DuplicateEnrollmentRule());
        service.addRule(new MaxSizeRule());

        Course calculusCourse = new Course("Calculus", 3);
        Student s1 = new Student("Toi", 12345);
        Student s2 = new Student("Qua", 67891);
        Student s3 = new Student("Deptrai", 01112);

        service1.enroll(s1, calculusCourse);
        service1.enroll(s2, calculusCourse);
        service1.enroll(s3, calculusCourse);

    }
}
