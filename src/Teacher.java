import java.util.*;

public class Teacher extends User {

    public Teacher(String name) {
        super(name, null); // rollNumber not needed for teacher
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
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
    }
}