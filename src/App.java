import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeaveService service = new LeaveService();

        System.out.println("=== Leave Management System ===");
        System.out.print("Enter your role (student/teacher): ");
        String role = sc.nextLine().trim().toLowerCase();

        if (role.equals("teacher")) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.println("Hello, " + name + "!");

            while (true) {
                System.out.println("\n1. View Leave Requests");
                System.out.println("2. View Student");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    List<LeaveRequest> pending = service.getPendingRequests();
                    if (pending.isEmpty()) {
                        System.out.println("No pending requests.");
                    } else {
                        for (LeaveRequest req : pending) {
                            System.out.println(req);
                        }
                        System.out.print("Enter roll number to approve/reject: ");
                        String roll = sc.next();
                        System.out.print("Approve (A) or Reject (R): ");
                        String decision = sc.next().toUpperCase();

                        if (decision.equals("A")) {
                            service.updateStatus(roll, "Approved");
                            service.incrementLeaveCount(roll);
                        } else {
                            service.updateStatus(roll, "Rejected");
                        }
                        service.removeRequest(roll);
                        System.out.println("Decision saved.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter roll number: ");
                    String roll = sc.next();
                    service.showStudentDetails(roll);
                } else {
                    break;
                }
            }

        } else if (role.equals("student")) {
            System.out.print("Enter your roll number: ");
            String roll = sc.nextLine();
            System.out.println("Hello, " + roll + "!");

            while (true) {
                System.out.println("\n1. View Details");
                System.out.println("2. Apply Leave");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    service.showStudentDetails(roll);
                } else if (choice == 2) {
                    System.out.print("From Date (YYYY-MM-DD): ");
                    String from = sc.next();
                    System.out.print("To Date (YYYY-MM-DD): ");
                    String to = sc.next();
                    sc.nextLine(); // consume newline
                    System.out.print("Reason: ");
                    String reason = sc.nextLine();

                    LeaveRequest req = new LeaveRequest(roll, from, to, reason, "Pending");
                    service.submitRequest(req);
                    System.out.println("Leave request submitted.");
                } else {
                    break;
                }
            }
        } else {
            System.out.println("Invalid role.");
        }

        sc.close();
    }
}