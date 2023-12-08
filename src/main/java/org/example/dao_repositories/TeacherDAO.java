package org.example.dao_repositories;

import org.example.model.Teacher;

import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> getTeachers();

    Teacher getTeacherById(int id);

    void addTeacher(String firstName, String middleName, String lastName);

    void editTeacher(int id,String firstName, String middleName, String lastName);

    void deleteTeacher(int id);
}
