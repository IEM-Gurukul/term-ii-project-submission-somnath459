import java.util.*;

class AttendanceSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Attendance Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Search Student");
            System.out.println("5. Attendance Summary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: markAttendance(); break;
                case 3: viewAttendance(); break;
                case 4: searchStudent(); break;
                case 5: attendanceSummary(); break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    private Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private void markAttendance() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter Status (Present/Absent): ");
        String status = sc.nextLine();

        s.markAttendance(date, status);
        System.out.println("Attendance marked successfully!");
    }

    private void viewAttendance() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);
        if (s != null) {
            s.viewAttendance();
        } else {
            System.out.println("Student not found!");
        }
    }

    private void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);
        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    private void attendanceSummary() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);
        if (s != null) {
            s.summary();
        } else {
            System.out.println("Student not found!");
        }
    }
}