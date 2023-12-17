package org.example.dao_repositories;

import org.example.model.Teacher;

import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> getTeachers();

    Teacher getTeacherById(int id);

    int addTeacher(String firstName, String middleName, String lastName);

    String editTeacher(int id,String firstName, String middleName, String lastName);

    String deleteTeacher(int id);
}
