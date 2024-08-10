package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;
import java.util.Objects;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getStudentsByGroup(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getStudentById(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        try {

            StudentGroup group = dataBase.getStudentGroupById(groupId);

            Student student = SpringConfig.getContext().getBean("student", Student.class);
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setGroup(group);
            student.setStatus(getStudentStatus(status));

            return dataBase.addStudent(student);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        try {
            StudentGroup group = dataBase.getStudentGroupById(groupId);

            Student student = SpringConfig.getContext().getBean("student", Student.class);
            student.setId(id);
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setGroup(group);
            student.setStatus(getStudentStatus(status));

            return dataBase.editStudent(student);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String deleteStudent(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.deleteStudent(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static StatusStudent getStudentStatus(String status) {

        StatusStudent newStatus = null;
        if (Objects.equals(StatusStudent.STUDIES.toString(), status)) {
            newStatus = StatusStudent.STUDIES;
        } else if (Objects.equals(StatusStudent.EXPELLED.toString(), status)) {
            newStatus = StatusStudent.EXPELLED;
        } else if (Objects.equals(StatusStudent.ACADEMIC_LEAVE.toString(), status)) {
            newStatus = StatusStudent.ACADEMIC_LEAVE;
        }

        return newStatus;
    }
}

