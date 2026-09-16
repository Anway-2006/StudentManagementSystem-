import java.util.*;

// Student Class (OOP)
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display method
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Grade: " + getGrade());
    }

    // Grade calculation
    String getGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }
}

// Main Class
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: viewStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateMarks(); break;
                    case 5: deleteStudent(); break;
                    case 6: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter valid input!");
                sc.nextLine(); // clear buffer
                choice = 0;
            }

        } while (choice != 6);
    }

    // Add Student
    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            students.add(new Student(id, name, marks));
            System.out.println("✅ Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input!");
            sc.nextLine();
        }
    }

    // View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }

    // Update Marks
    static void updateMarks() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();
                System.out.println("✅ Marks updated!");
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("✅ Student deleted!");
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }
}