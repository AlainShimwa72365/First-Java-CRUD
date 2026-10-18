
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Database System (Collaboration version)===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update a Student's details");
            System.out.println("4. Delete a Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    viewStudents();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    deleteStudent();
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(name);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    static void updateStudent() {
        viewStudents();
        if (students.isEmpty()) return;

        System.out.print("Enter student number to update: ");

        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < students.size()) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                students.set(index, name);
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Invalid student number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    static void deleteStudent() {
        viewStudents();
        if (students.isEmpty()) return;

        System.out.print("Enter student number to delete: ");

        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < students.size()) {
                students.remove(index);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Invalid student number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
