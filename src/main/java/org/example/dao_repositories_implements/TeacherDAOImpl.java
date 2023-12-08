package org.example.dao_repositories_implements;

import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;

import java.util.ArrayList;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public ArrayList<Teacher> getTeachers() {
        //Возвращает массив конкретных объектов Teacher
        Teacher teacher1 = new Teacher(1,"Артем","Иванович","Иванов");
        Teacher teacher2 = new Teacher(2,"Андрей","Иванович","Теонов");
        ArrayList<Teacher> arrayList = new ArrayList<>();
        arrayList.add(teacher1);
        arrayList.add(teacher2);
        //
        return arrayList;
    }

    @Override
    public Teacher getTeacherById(int id) {
        //Возвращает конкретный объект Teacher
        return new Teacher(id,"Артем","Иванович","Иванов");
        //
    }

    @Override
    public void addTeacher(String firstName, String middleName, String lastName) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Преподаватель добавлен");
    }

    @Override
    public void editTeacher(int id, String firstName, String middleName, String lastName) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Преподаватель изменен");
    }

    @Override
    public void deleteTeacher(int id) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Преподаватель удален");
    }
}
