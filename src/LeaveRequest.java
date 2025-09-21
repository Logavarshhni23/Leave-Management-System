public class LeaveRequest {
    private String rollNumber, fromDate, toDate, reason, status;

    public LeaveRequest(String rollNumber, String fromDate, String toDate, String reason, String status) {
        this.rollNumber = rollNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    public String getRollNumber() { return rollNumber; }
    public String getFromDate() { return fromDate; }
    public String getToDate() { return toDate; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", From: " + fromDate + ", To: " + toDate + ", Reason: " + reason + ", Status: " + status;
    }
}