interface MessageSender {
    void send(String to, String message);
}

class EmailService implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending EMAIL to " + to + ": " + message);
    }
}

class SmsService implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}

class NotificationService {

    private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void sendWelcome(String to) {
        // 3. Chỉ gọi hàm của Interface, không quan tâm bên dưới là Email hay SMS
        sender.send(to, "Welcome to our course!");
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService emailNotif = new NotificationService(new EmailService());
        emailNotif.sendWelcome("student@school.com");

        NotificationService smsNotif = new NotificationService(new SmsService());
        smsNotif.sendWelcome("0909123456");
    }
}