package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private final DataBase dataBase;

    public StudentDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) throws EntityNotFoundInDataBase {
        return dataBase.getStudentsByGroup(id);
    }

    @Override
    public Student getStudentById(int id) throws EntityNotFoundInDataBase {
        return dataBase.getStudentById(id);
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, int groupId, String status) throws AddEntityMatchData, EntityNotFoundInDataBase {
        StudentGroup group = dataBase.getStudentGroupById(groupId);

        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setGroup(group);
        student.setStatus(StatusStudent.valueOf(status.toUpperCase()));

        return dataBase.addStudent(student);
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, int groupId, String status) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        StudentGroup group = dataBase.getStudentGroupById(groupId);

        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setId(id);
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setGroup(group);
        student.setStatus(StatusStudent.valueOf(status.toUpperCase()));

        return dataBase.editStudent(student);
    }

    @Override
    public String deleteStudent(int id) throws EntityNotFoundInDataBase {
        return dataBase.deleteStudent(id);
    }
}

