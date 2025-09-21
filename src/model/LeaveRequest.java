package model;

public class LeaveRequest {
    private String studentRollNumber;
    private String startDate; 
    private String endDate; 
    private int duration;  
    private String reason;   
    private String status; 

    public LeaveRequest(String studentRollNumber, String startDate, String endDate, int duration,  String reason, String status)
    {
        this.studentRollNumber = studentRollNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.reason = reason;
        this.status = status;
    }

    public String getStudentRollNumber() { 
        return studentRollNumber; }
    public String getStartDate() { 
        return startDate; }
    public String getEndDate() { 
        return endDate; }
    public int getDuration() { 
        return duration; }
    public String getReason() { 
        return reason; }
    public String getStatus() { 
        return status; }

    public void setStatus(String status) { this.status = status; }

}
