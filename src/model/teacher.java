package model;
public class teacher extends user{
    int teacherID;
    teacher(String username,String password,int teacherID)
    {
        super(username, password);
        this.teacherID = teacherID;
    }
    public int getTeacherId() {
        return teacherID;
    }

    @Override
    public void login() {
        System.out.println("Teacher logged in: " + getUsername());
    }

}
