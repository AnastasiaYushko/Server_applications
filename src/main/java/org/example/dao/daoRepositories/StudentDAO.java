package org.example.dao.daoRepositories;

import org.example.model.Student;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface StudentDAO {

    ArrayList<Student> getStudentsByGroup(int id) throws RepositoryException, EntityNotFoundInDataBase;

    Student getStudentById(int id) throws RepositoryException, EntityNotFoundInDataBase;

    int addStudent(String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException, AddEntityMatchData, EntityNotFoundInDataBase;

    String editStudent(int id, String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException, EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict;

    String deleteStudent(int id) throws RepositoryException, EntityNotFoundInDataBase;
}
