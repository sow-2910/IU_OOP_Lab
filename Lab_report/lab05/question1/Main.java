package question1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog(null, "What is your name?", "Input",
                JOptionPane.QUESTION_MESSAGE);

        if (userName != null && !userName.trim().isEmpty()) {
            String greetingMessage = "Welcome," + userName + ", to Java Programming!";

            JOptionPane.showMessageDialog(null, greetingMessage, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "You have not entered your name", "Message",
                    JOptionPane.WARNING_MESSAGE);
        }
        System.exit(0);
    }
}
