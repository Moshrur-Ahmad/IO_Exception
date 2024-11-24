import java.io.*;
import java.util.*;

public class StudentCSVManager {
    static class Student {
        String name;
        int rollNo;
        int marks;

        public Student(String name, int rollNo, int marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return rollNo + ", " + name + ", " + marks;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File("students.csv");

        // Read CSV
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        }

        // Menu
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Search 2. Update 3. Delete 4. Display 5. Exit");
            int choice = sc.nextInt();
            if (choice == 5) break;

            switch (choice) {
                case 1 -> searchStudent(students, sc);
                case 2 -> updateStudent(students, sc);
                case 3 -> deleteStudent(students, sc);
                case 4 -> displayStudents(students);
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void searchStudent(List<Student> students, Scanner sc) {
        System.out.print("Enter roll number to search: ");
        int rollNo = sc.nextInt();
        students.stream()
                .filter(s -> s.rollNo == rollNo)
                .forEach(System.out::println);
    }

    static void updateStudent(List<Student> students, Scanner sc) {
        System.out.print("Enter roll number to update: ");
        int rollNo = sc.nextInt();
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.print("Enter new name: ");
                s.name = sc.next();
                System.out.print("Enter new marks: ");
                s.marks = sc.nextInt();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void deleteStudent(List<Student> students, Scanner sc) {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        students.removeIf(s -> s.rollNo == rollNo);
    }

    static void displayStudents(List<Student> students) {
        students.forEach(System.out::println);
    }
}
