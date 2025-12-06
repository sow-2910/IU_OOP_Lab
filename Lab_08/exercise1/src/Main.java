import java.util.List;

class CourseDataLoader {
    public List<String> getStudents(String courseId) {
        return List.of("Cristiano Ronaldo", "Lionel Messi", "Erling Neymar");
    }

    public List<Integer> getGrades(String courseId) {
        return List.of(9, 7, 8);
    }

    public void saveData(String courseId) {
        System.out.println("Connecting to database...");
        System.out.println("Loading students and grades for course " + courseId + "...");
    }
}

class GradeCalculator {
    public double calculateAvgGrade(List<Integer> grades) {
        double total = 0;
        for (Integer g : grades) {
            total += g;
        }
        return total / grades.size();
    }
}

class ReportFormatter {
    private final StringBuilder report = new StringBuilder();

    public ReportFormatter(String courseId, List<String> students, List<Integer> grades, double avg) {
        report.append("Course ID: ").append(courseId).append("\n");
        report.append("Students and grades:\n");
        for (int i = 0; i < students.size(); i++) {
            report.append("- ").append(students.get(i))
                    .append(": ").append(grades.get(i)).append("\n");
        }
        report.append("Average grade: ").append(avg).append("\n");
    }

    public String getReport() {
        return report.toString();
    }
}

class ReportStorage {
    public void saveFile() {
        System.out.println("Saving report.txt");
    }
}

class TeacherNotifier {
    public void sendEmailToTeacher(String report) {
        System.out.println("Sending email to teacher with report attached");
        System.out.println(report);
    }
}

class CourseReportManager {
    private CourseDataLoader courseDataLoader = new CourseDataLoader();
    private GradeCalculator gradeCalculator = new GradeCalculator();
    private ReportFormatter reportFormatter;
    private ReportStorage reportStorage = new ReportStorage();
    private TeacherNotifier teacherNotifier = new TeacherNotifier();

    public void generateReport(String courseId) {
        courseDataLoader.saveData(courseId);
        var students = courseDataLoader.getStudents(courseId);
        var grades = courseDataLoader.getGrades(courseId);
        double avg = gradeCalculator.calculateAvgGrade(grades);
        reportFormatter = new ReportFormatter(courseId, students, grades, avg);
        String reportContent = reportFormatter.getReport();
        reportStorage.saveFile();
        teacherNotifier.sendEmailToTeacher(reportContent);

    }

}

public class Main {
    public static void main(String[] args) {
        CourseReportManager courseReportManager = new CourseReportManager();
        courseReportManager.generateReport("1");
    }
}
