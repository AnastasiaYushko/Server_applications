package org.example.daoRepositories;

import org.example.model.Student;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface StudentDAO {

    ArrayList<Student> getStudentsByGroup(int id) throws RepositoryException;

    Student getStudentById(int id) throws RepositoryException;

    int addStudent(String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException;

    String editStudent(int id, String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException;

    String deleteStudent(int id) throws RepositoryException ;
}
