public class Main {
    public static void main(String[] args) {
        studentValidator validator = new studentValidator();
        studentRepository repository = new studentRepository();
        EmailService emailService = new EmailService();

        studentManager manager = new studentManager(validator, repository, emailService);
        manager.addStudent("Phat", "ITCSIU24068@student.hcmiu,edu.vn");
        manager.addStudent("huy", "ITCSIU24033");
        //this design follow SRP since each class have only one responsibility, validator have one class, one class for saving data, one class for sending email.
    }
}
