import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Leave Management System ===");
        System.out.print("Enter your role (student/teacher): ");
        String role = sc.nextLine().trim().toLowerCase();

        User user;

        if (role.equals("teacher")) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            user = new Teacher(name);
        } else if (role.equals("student")) {
            System.out.print("Enter your roll number: ");
            String roll = sc.nextLine();
            user = new Student("Student", roll); 
        } else {
            System.out.println("Invalid role.");
            sc.close();
            return;
        }

        user.showMenu(); 
        sc.close();
    }
}