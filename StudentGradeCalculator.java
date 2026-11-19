
import javax.swing.*;
import java.awt.*;

public class StudentGradeCalculator extends JFrame {

    JTextField nameField, idField;
    JTextField banglaField, englishField, mathField;

    JLabel resultLabel;

    public StudentGradeCalculator() {

        setTitle("Student Grade Calculator");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel(
                "Student Grade Calculator",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 10, 20));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Bangla Marks:"));
        banglaField = new JTextField();
        inputPanel.add(banglaField);

        inputPanel.add(new JLabel("English Marks:"));
        englishField = new JTextField();
        inputPanel.add(englishField);

        inputPanel.add(new JLabel("Math Marks:"));
        mathField = new JTextField();
        inputPanel.add(mathField);

        // Buttons
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        // Result Panel
        resultLabel = new JLabel(
                "Result will appear here",
                SwingConstants.CENTER);

        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(
                BorderFactory.createTitledBorder("Student Result"));

        resultPanel.add(resultLabel, BorderLayout.CENTER);

        // Center Panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(resultPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // Button Actions
        calculateButton.addActionListener(e -> calculateResult());

        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    public void calculateResult() {

        try {

            String name = nameField.getText().trim();
            String id = idField.getText().trim();

            if (name.isEmpty() || id.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Student Name and ID!");

                return;
            }

            double bangla = Double.parseDouble(banglaField.getText());
            double english = Double.parseDouble(englishField.getText());
            double math = Double.parseDouble(mathField.getText());

            if (bangla < 0 || bangla > 100 ||
                    english < 0 || english > 100 ||
                    math < 0 || math > 100) {

                JOptionPane.showMessageDialog(
                        this,
                        "Marks must be between 0 and 100!");

                return;
            }

            double total = bangla + english + math;

            double average = total / 3;

            String grade;

            if (bangla < 33 || english < 33 || math < 33) {
                grade = "F";
            } else if (average >= 80) {
                grade = "A+";
            } else if (average >= 70) {
                grade = "A";
            } else if (average >= 60) {
                grade = "A-";
            } else if (average >= 50) {
                grade = "B";
            } else if (average >= 40) {
                grade = "C";
            } else {
                grade = "D";
            }

            // Show Complete Result
            resultLabel.setText(
                    "<html><center>" +
                            "Name: " + name +
                            "<br>ID: " + id +
                            "<br>Total: " + total +
                            "<br>Average: " + String.format("%.2f", average) +
                            "<br><br>Grade: " + grade +
                            "</center></html>");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid marks in all subjects!");

        }
    }

    public void clearFields() {

        nameField.setText("");
        idField.setText("");
        banglaField.setText("");
        englishField.setText("");
        mathField.setText("");

        resultLabel.setText("Result will appear here");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new StudentGradeCalculator();
        });
    }
}