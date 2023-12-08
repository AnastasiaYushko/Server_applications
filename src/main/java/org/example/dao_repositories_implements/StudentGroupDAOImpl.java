package org.example.dao_repositories_implements;

import org.example.dao_repositories.StudentGroupDAO;
import org.example.model.StudentGroup;

import java.util.ArrayList;

public class StudentGroupDAOImpl implements StudentGroupDAO {
    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        //Возвращает массив конкретных объектов StudentGroup
        StudentGroup group1 = new StudentGroup(0, "ММБ-104-01");
        StudentGroup group2 = new StudentGroup(1, "ММБ-104-02");
        ArrayList<StudentGroup> arrayList = new ArrayList<>();
        arrayList.add(group1);
        arrayList.add(group2);
        //
        return arrayList;
    }

    @Override
    public StudentGroup getStudentGroupById(int id) {
        //Возвращает конкретный объект StudentGroup
        StudentGroup group = new StudentGroup(id,"ММБ-103-01");
        //
        return group;
    }

    @Override
    public void addStudentGroup(String name) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Группа добавлена");
    }

    @Override
    public void editStudentGroup(int id, String name) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Группа изменена");
    }

    @Override
    public void deleteStudentGroup(int id) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Группа удалена");
    }
}
