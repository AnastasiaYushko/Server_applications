package org.example.daoRepositories;

import org.example.model.Teacher;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> getTeachers();

    Teacher getTeacherById(int id) throws RepositoryException;

    int addTeacher(String firstName, String middleName, String lastName) throws RepositoryException;

    String editTeacher(int id, String firstName, String middleName, String lastName) throws RepositoryException;

    String deleteTeacher(int id) throws RepositoryException;
}
