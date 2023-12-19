package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;

import java.util.ArrayList;
import java.util.Objects;

public class StudentDAOImpl implements StudentDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) {
        StudentGroup studentGroup = dataBase.getStudentGroupById(id);
        if (studentGroup == null){
            throw new NullPointerException("Такой группы нет в системе");
        }
        return dataBase.getStudentsByGroup(id);
    }

    @Override
    public Student getStudentById(int id) {
        Student student = dataBase.getStudentById(id);
        if (student == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        return student;
    }

    @Override
    public int addStudent(String lastName, String firstName, String middleName, String groupId, String status) {
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        if (group == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        if (getStatus(status) == null) {
            throw new NullPointerException("Неверный статус");
        }
        Student student = new Student(0, lastName, firstName, middleName, getStatus(status), group);
        return dataBase.addStudent(student);
    }

    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, String groupId, String status) {
        StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
        Student student = new Student(id, lastName, firstName, middleName, getStatus(status), group);
        if (dataBase.getStudentById(id) == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }

        if (getStatus(status) == null) {
            throw new NullPointerException("Неверный статус");
        }
        dataBase.editStudent(student);
        return "Данные студента изменены";
    }

    @Override
    public String deleteStudent(int id) {
        if (dataBase.getStudentById(id) == null) {
            throw new NullPointerException("Такого студента нет в системе");
        }
        dataBase.deleteStudent(id);
        return "Студент удален";
    }

    private StatusStudent getStatus(String status) {
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

