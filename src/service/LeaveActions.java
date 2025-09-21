package service;
import model.LeaveRequest;
public interface LeaveActions {
    void applyLeave(LeaveRequest request);
    void approveLeave(String rollNumber);
    void rejectLeave(String rollNumber);
    LeaveRequest viewLeaveStatus(String rollNumber);
} 
