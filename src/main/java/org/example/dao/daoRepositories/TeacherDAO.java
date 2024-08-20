package org.example.dao.daoRepositories;

import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface TeacherDAO {

    ArrayList<Teacher> getTeachers();

    Teacher getTeacherById(int id) throws RepositoryException, EntityNotFoundInDataBase;

    int addTeacher(String firstName, String middleName, String lastName) throws RepositoryException, AddEntityMatchData;

    String editTeacher(int id, String firstName, String middleName, String lastName) throws RepositoryException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    String deleteTeacher(int id) throws RepositoryException, EntityNotFoundInDataBase;
}
