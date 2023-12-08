package org.example.dao_repositories_implements;

import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;

import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {
    @Override
    public ArrayList<Subject> getSubjects() {
        //Возвращает массив конкретных объектов Subject
        Subject subject1 = new Subject(1,"Философия");
        Subject subject2 = new Subject(1,"Правоведение");
        ArrayList<Subject> arrayList = new ArrayList<>();
        arrayList.add(subject1);
        arrayList.add(subject2);
        //
        return arrayList;
    }

    @Override
    public Subject getSubjectById(int id) {
        //Возвращает конкретный объект Subject
        return new Subject(id,"Философия");
        //
    }

    @Override
    public void addSubject(String name) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Предмет добавлен");
    }

    @Override
    public void editSubject(int id, String name) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Предмет изменен");
    }

    @Override
    public void deleteSubject(int id) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Предмет удален");
    }
}
