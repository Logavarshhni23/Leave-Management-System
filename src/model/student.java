package model;
public class student extends user{
    String rollNumber;
    int totalLeave;

    student(String username,String password,String rollNumber)
    {
        super(username,password);
        this.rollNumber=rollNumber;
        this.totalLeave=0;
    }

    public String getStudentRollNumber() {
        return rollNumber;
    }

    public int getTotalLeaves() {
        return totalLeave;
    }

    public void setTotalLeaves(int totalLeave) {
        this.totalLeave = totalLeave;
    }

    @Override
    public void login() {
        System.out.println("Student logged in: " + getUsername());
        // Load student leave data if needed
    }

}
