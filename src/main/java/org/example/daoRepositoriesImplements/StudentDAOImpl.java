package org.example.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.daoRepositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;
import java.util.Objects;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private final DataBase dataBase;

    public StudentDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) throws RepositoryException {
        try {
            return dataBase.getStudentsByGroup(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int id) throws RepositoryException {
        try {
            return dataBase.getStudentById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException {
        try {
            StudentGroup group = dataBase.getStudentGroupById(groupId);

            Student student = SpringConfig.getContext().getBean("student", Student.class);
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setGroup(group);
            student.setStatus(getStudentStatus(status));

            return dataBase.addStudent(student);
        } catch (AddEntityMatchData | EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, int groupId, String status) throws RepositoryException {
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
        } catch (EntityNotFoundInDataBase | StupidChanges | ChangesEntityLeadToConflict e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String deleteStudent(int id) throws RepositoryException {
        try {
            return dataBase.deleteStudent(id);
        } catch (EntityNotFoundInDataBase e) {
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

