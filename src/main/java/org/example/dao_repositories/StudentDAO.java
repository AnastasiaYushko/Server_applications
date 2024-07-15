package org.example.dao_repositories;

import org.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface StudentDAO {

    ArrayList<Student> getStudentsByGroup(int id);

    Student getStudentById(int id);

    int addStudent(String lastName, String firstName, String middleName, String groupId, String status);

    String editStudent(int id, String lastName, String firstName, String middleName, String groupId, String status) throws Exception;

    String deleteStudent(int id) throws Exception;
}
