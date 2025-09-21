package service;

import da.TeacherDA;

public class AuthService {
    private TeacherDA teacherDA = new TeacherDA();

    public boolean loginAsTeacher(String username, String password) {
        return teacherDA.authenticateTeacher(username, password);
    }
}