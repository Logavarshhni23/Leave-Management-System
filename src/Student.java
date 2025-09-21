import java.util.List;
import java.util.Scanner;

public class Student extends User {

    public Student(String name, String rollNumber) {
        super(name, rollNumber);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. View Details");
            System.out.println("2. Apply Leave");
            System.out.println("3. View Leave Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                service.showStudentDetails(rollNumber);
            } else if (choice == 2) {
                System.out.print("From Date (YYYY-MM-DD): ");
                String from = sc.next();
                System.out.print("To Date (YYYY-MM-DD): ");
                String to = sc.next();
                sc.nextLine(); 
                System.out.print("Reason: ");
                String reason = sc.nextLine();

                LeaveRequest req = new LeaveRequest(rollNumber, from, to, reason, "Pending");
                service.submitRequest(req);
                System.out.println("Leave request submitted.");
            } else if(choice==3){
                List<LeaveRequest> requests = service.getLeaveRequestsByRoll(rollNumber);
                if (requests.isEmpty()) {
                    System.out.println("No leave history found.");
                } else {
                    for (LeaveRequest req : requests) {
                        System.out.println(req);
                    }
               }     
            }
            else {
                break;
            }
        }
    }
}