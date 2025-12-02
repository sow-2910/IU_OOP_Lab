
class studentValidator {
    public boolean isValid(String name, String email) {
        return !(name == null || name.isBlank() || email == null || !email.contains("@"));
    }
}

class studentRepository {
    public void save(String name, String email) {
        System.out.println("Student name: " + name + " saved to database");
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        System.out.println("Sending welcome message to: " + email);
    }
}

public class studentManager {
    private studentValidator validator;
    private studentRepository repository;
    private EmailService emailService;

    public studentManager(studentValidator validator, studentRepository repository, EmailService emailService) {
        this.validator = validator;
        this.repository = repository;
        this.emailService = emailService;
    }

    public void addStudent(String name, String email) {
        if (!validator.isValid(name, email)) {
            System.out.println("Invalid Data input");
            return;
        }
        repository.save(name, email);
        emailService.sendWelcomeEmail(email);
    }

}
