package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBManager;

public class StudentDA {

    public void incrementLeaveCount(String rollNumber) {
        String query = "UPDATE student SET leaveCount = leaveCount + 1 WHERE rollNumber = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, rollNumber);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating leave count: " + e.getMessage());
        }
    }
}
