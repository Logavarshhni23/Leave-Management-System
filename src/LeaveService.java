import java.sql.*;
import java.util.*;

public class LeaveService {

    public void submitRequest(LeaveRequest req) {
        String query = "INSERT INTO leave_requests (rollNumber, fromDate, toDate, reason, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, req.getRollNumber());
            stmt.setString(2, req.getFromDate());
            stmt.setString(3, req.getToDate());
            stmt.setString(4, req.getReason());
            stmt.setString(5, req.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error submitting request: " + e.getMessage());
        }
    }

    public List<LeaveRequest> getPendingRequests() {
        List<LeaveRequest> list = new ArrayList<>();
        String query = "SELECT * FROM leave_requests WHERE status = 'Pending'";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new LeaveRequest(
                    rs.getString("rollNumber"),
                    rs.getString("fromDate"),
                    rs.getString("toDate"),
                    rs.getString("reason"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching requests: " + e.getMessage());
        }
        return list;
    }

    public void updateStatus(String roll, String status) {
        String query = "UPDATE leave_requests SET status = ? WHERE rollNumber = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setString(2, roll);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
        }
    }

    public void removeRequest(String roll) {
        String query = "DELETE FROM leave_requests WHERE rollNumber = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roll);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error removing request: " + e.getMessage());
        }
    }

    public void incrementLeaveCount(String roll) {
        String query = "UPDATE student SET leaveCount = leaveCount + 1 WHERE rollNumber = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roll);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating leave count: " + e.getMessage());
        }
    }

    public void showStudentDetails(String roll) {
        String query = "SELECT * FROM student WHERE rollNumber = ?";
        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roll);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Name: " + rs.getString("username")); // ✅ fixed from "name"
                System.out.println("Roll No: " + rs.getString("rollNumber"));
                System.out.println("Leave Count: " + rs.getInt("leaveCount"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching student: " + e.getMessage());
        }
    }
    public List<LeaveRequest> getLeaveRequestsByRoll(String roll) {
        List<LeaveRequest> list = new ArrayList<>();
        String query = "SELECT * FROM leave_requests WHERE rollNumber = ?";
        try (Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roll);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new LeaveRequest(
                    rs.getString("rollNumber"),
                    rs.getString("fromDate"),
                    rs.getString("toDate"),
                    rs.getString("reason"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching leave history: " + e.getMessage());
        }
        return list;
    }

}