import java.util.*;

class Student extends Person {
    private Map<String, String> attendance;

    public Student(int id, String name) {
        super(id, name);
        attendance = new HashMap<>();
    }

    public void markAttendance(String date, String status) {
        attendance.put(date, status);
    }

    public void viewAttendance() {
        if (attendance.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }

        System.out.println("Attendance Records:");
        for (String date : attendance.keySet()) {
            System.out.println("Date: " + date + " | Status: " + attendance.get(date));
        }
    }

    public void summary() {
        int present = 0, absent = 0;

        for (String status : attendance.values()) {
            if (status.equalsIgnoreCase("Present")) present++;
            else absent++;
        }

        System.out.println("Total Present: " + present);
        System.out.println("Total Absent: " + absent);
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}