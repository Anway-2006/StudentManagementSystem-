import java.util.*;

// 1. Student Class
class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Marks: " + marks + ", Grade: " + getGrade());
    }
}

// 2. StudentService Class
class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added!");
    }

    void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found!");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    void updateMarks(int id, double newMarks) {
        Student s = searchStudent(id);
        if (s != null) {
            s.marks = newMarks;
            System.out.println("✅ Marks updated!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    void deleteStudent(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                System.out.println("✅ Student deleted!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }
}

// 3. InputHelper Class
class InputHelper {
    Scanner sc = new Scanner(System.in);

    int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Enter valid number!");
                sc.nextLine();
            }
        }
    }

    double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Enter valid marks!");
                sc.nextLine();
            }
        }
    }

    String getString(String msg) {
        sc.nextLine(); // clear buffer
        System.out.print(msg);
        return sc.nextLine();
    }
}

// 4. Menu Class
class Menu {
    void displayMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }
}

// 5. Main Class
public class Main {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        InputHelper input = new InputHelper();
        Menu menu = new Menu();

        int choice;

        do {
            menu.displayMenu();
            choice = input.getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    int id = input.getInt("Enter ID: ");
                    String name = input.getString("Enter Name: ");
                    double marks = input.getDouble("Enter Marks: ");
                    service.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    id = input.getInt("Enter ID to search: ");
                    Student s = service.searchStudent(id);
                    if (s != null) s.display();
                    else System.out.println("❌ Student not found!");
                    break;

                case 4:
                    id = input.getInt("Enter ID: ");
                    double newMarks = input.getDouble("Enter new marks: ");
                    service.updateMarks(id, newMarks);
                    break;

                case 5:
                    id = input.getInt("Enter ID: ");
                    service.deleteStudent(id);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}
