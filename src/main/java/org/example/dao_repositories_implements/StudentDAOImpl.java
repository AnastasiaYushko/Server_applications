package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.isNull;

@Repository("student_dao_impl")
public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup studentGroup = dataBase.getStudentGroupById(id);
        if (isNull(studentGroup)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        return dataBase.getStudentsByGroup(id);
    }

    @Override
    public Student getStudentById(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Student student = dataBase.getStudentById(id);
        if (isNull(student)) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        return student;
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, String groupId, String status) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        StatusStudent newStatus = getStudentStatus(status);
        if (isNull(newStatus)) {
            throw new NullPointerException("Неверный статус");
        }
        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setGroup(group);
        student.setStatus(newStatus);
        return dataBase.addStudent(student);
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, String groupId, String status) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        if (isNull(dataBase.getStudentById(id))) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        StatusStudent newStatus = getStudentStatus(status);
        if (isNull(newStatus)) {
            throw new NullPointerException("Неверный статус");
        }
        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setId(id);
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setGroup(group);
        student.setStatus(newStatus);

        dataBase.editStudent(student);

        return "Данные студента изменены";
    }

    @Override
    public String deleteStudent(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        if (isNull(dataBase.getStudentById(id))) {
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

