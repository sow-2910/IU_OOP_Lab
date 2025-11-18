package question8;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel
        BarChartPanel panel = new BarChartPanel();
        frame.add(panel);

        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Read 5 numbers using dialogs
        int[] values = new int[5];
        for (int i = 0; i < 5; i++) {
            String input = JOptionPane.showInputDialog(
                    frame,
                    "Enter the length of the bar " + (i + 1),
                    "Input",
                    JOptionPane.QUESTION_MESSAGE);

            // Parse input and handle cancellation
            if (input == null) {
                // User clicked Cancel, use default value
                values[i] = 0;
            } else {
                try {
                    values[i] = Integer.parseInt(input);
                    if (values[i] < 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive number.", "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                        i--; // re-prompt for this bar
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    i--; // re-prompt for this bar
                }
            }
        }

        // Set values and display chart
        panel.setValues(values);
    }
}
