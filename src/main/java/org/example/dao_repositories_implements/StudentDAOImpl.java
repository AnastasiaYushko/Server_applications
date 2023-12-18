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

    //+!
    @Override
    public ArrayList<Student> getStudentsByGroup(int id) {
        return dataBase.getStudentsByGroup(id);
    }

    //+!
    @Override
    public Student getStudentById(int id) {
        return dataBase.getStudentById(id);
    }

    //+!
    @Override
    public int addStudent(String lastName, String firstName, String middleName, String groupId, String status) {
        try {
            StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
            if (group!= null) {
                Student student = new Student(0, lastName, firstName, middleName, getStatus(status), group);
                return dataBase.addStudent(student);
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (Exception e){
            throw new NullPointerException();
        }
    }

    //+!
    @Override
    public String editStudent(int id, String lastName, String firstName, String middleName, String groupId, String status){
        try {
            StudentGroup group = dataBase.getStudentGroupById(Integer.parseInt(groupId));
            Student student = new Student(id, lastName, firstName, middleName, getStatus(status), group);
            if (dataBase.getStudentById(id) != null){
                dataBase.editStudent(student);
                return "Данные студента изменены";
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (Exception e){
            throw new NullPointerException();
        }
    }

    //+!
    @Override
    public String deleteStudent(int id) {
        if (dataBase.getStudentById(id) != null){
            dataBase.deleteStudent(id);
            return "Студент удален";
        }
        else {
            throw new NullPointerException();
        }
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

