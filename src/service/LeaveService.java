package service;
import dao.LeaveDAO;
import model.LeaveRequest;
public class LeaveService implements LeaveActions{
    private LeaveDAO leaveDAO = new LeaveDAO();

    @Override
    public void applyLeave(LeaveRequest request)
    {
        leaveDAO.insertLeaveRequest(request);
    }
    @Override
    public void approveLeave(String rollNumber) {
        leaveDAO.updateLeaveStatus(rollNumber, "Approved");
    }

    @Override
    public void rejectLeave(String rollNumber) {
        leaveDAO.updateLeaveStatus(rollNumber, "Rejected");
    }

    @Override
    public LeaveRequest viewLeaveStatus(String rollNumber) {
        return leaveDAO.getLeaveByRollNumber(rollNumber);
    }



}
