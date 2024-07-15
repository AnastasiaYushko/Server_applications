package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

@Repository("student_dao_impl")
public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup studentGroup = dataBase.getStudentGroupById(id);
        if (studentGroup == null){
            throw new NullPointerException("Такой группы нет в системе");
        }
        return dataBase.getStudentsByGroup(id);
    }

    @Override
    public Student getStudentById(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Student student = dataBase.getStudentById(id);
        if (student == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        return student;
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, String groupId, String status) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        if (group == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        if (getStudentStatus(status) == null) {
            throw new NullPointerException("Неверный статус");
        }
        Student student = new Student(0, lastName, firstName, middleName, getStudentStatus(status), group);
        return dataBase.addStudent(student);
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, String groupId, String status) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        Student student = new Student(id, lastName, firstName, middleName, getStudentStatus(status), group);
        if (dataBase.getStudentById(id) == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }

        if (getStudentStatus(status) == null) {
            throw new NullPointerException("Неверный статус");
        }
        dataBase.editStudent(student);
        return "Данные студента изменены";
    }

    @Override
    public String deleteStudent(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        if (dataBase.getStudentById(id) == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        dataBase.deleteStudent(id);
        return "Студент удален";
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

