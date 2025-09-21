package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.LeaveRequest;
import da.DBManager;

public class LeaveDA {

    public void insertLeaveRequest(LeaveRequest request) {
        String query = "INSERT INTO leave_requests (rollNumber, startDate, endDate, duration, reason, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, request.getStudentRollNumber());
            stmt.setString(2, request.getStartDate());
            stmt.setString(3, request.getEndDate());
            stmt.setInt(4, request.getDuration());
            stmt.setString(5, request.getReason());
            stmt.setString(6, request.getStatus());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting leave request: " + e.getMessage());
        }
    }

    public void updateLeaveStatus(String rollNumber, String newStatus) {
        String query = "UPDATE leave_requests SET status = ? WHERE rollNumber = ?";

        try (Connection conn = DBManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, newStatus);
        stmt.setString(2, rollNumber);

        stmt.executeUpdate();

        } catch (SQLException e) {
        System.out.println("Error updating leave status: " + e.getMessage());
        }
    }

    public LeaveRequest getLeaveByRollNumber(String rollNumber) {
        String query = "SELECT * FROM leave_requests WHERE rollNumber = ?";
        LeaveRequest request = null;

        try (Connection conn = DBManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, rollNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                request = new LeaveRequest(
                    rs.getString("rollNumber"),
                    rs.getString("startDate"),
                    rs.getString("endDate"),
                    rs.getInt("duration"),
                    rs.getString("reason"),
                    rs.getString("status")
           );
        }

        } catch (SQLException e) {
            System.out.println("Error fetching leave request: " + e.getMessage());
        }

        return request;
    }
}