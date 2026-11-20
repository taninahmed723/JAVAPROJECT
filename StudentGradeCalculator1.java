import java.util.Scanner;

public class StudentGradeCalculator1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Student Information
        System.out.println("===== Student Grade Management System =====");

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        // Subject Marks
        System.out.print("Enter Math Marks: ");
        double math = input.nextDouble();

        System.out.print("Enter English Marks: ");
        double english = input.nextDouble();

        System.out.print("Enter Java Marks: ");
        double java = input.nextDouble();

        // Calculate Total and Average
        double total = math + english + java;

        double average = total / 3;

        // Calculate Grade
        String grade;

        if (average >= 80) {
            grade = "A+";
        } else if (average >= 70) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else if (average >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Pass or Fail
        String result;

        if (math >= 33 && english >= 33 && java >= 33) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        // Display Result
        System.out.println("\n===== Student Result =====");

        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);

        System.out.println("Math Marks: " + math);
        System.out.println("English Marks: " + english);
        System.out.println("Java Marks: " + java);

        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Result: " + result);

        input.close();
    }
}