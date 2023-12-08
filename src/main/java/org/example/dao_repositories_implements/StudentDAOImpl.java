package org.example.dao_repositories_implements;

import org.example.dao_repositories.StudentDAO;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;

import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getStudentsByGroup(int id) {
        //Возвращает массив конкретных объектов Student
        StudentGroup group = new StudentGroup(id, "ММБ-104-02");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1,"Романов","Евгений","Ильич",statusStudent,group);
        Student student2 = new Student(2,"Романова","Евгений","Ильинична",statusStudent,group);
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        //
        return arrayList;
    }

    @Override
    public Student getStudentById(int id) {
        StudentGroup group = new StudentGroup(1, "ММБ-104-02");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        return new Student(id,"Романов","Евгений","Ильич",statusStudent,group);
    }

    @Override
    public void addStudent(String lastName, String firstName,String middleName,String groupId,String status) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Студент добавлен");
    }

    @Override
    public void editStudent(int id,String lastName, String firstName,String middleName,String groupId,String status) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Данные студента изменены");
    }

    @Override
    public void deleteStudent(int id) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Студент удален");
    }
}

