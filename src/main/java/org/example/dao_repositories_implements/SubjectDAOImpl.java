package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;

import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public ArrayList<Subject> getSubjects() {
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) {
        Subject subject = dataBase.getSubjectById(id);
        if (subject == null){
            throw new NullPointerException("Такого предмета нет в системе");
        }
        return subject;
    }

    @Override
    public int addSubject(String name) {
        Subject subject = new Subject(0, name);
        return dataBase.addSubject(subject);
    }

    @Override
    public String editSubject(int id, String name) {
        Subject subject1 = dataBase.getSubjectById(id);
        if (subject1 != null) {
            Subject subject = new Subject(id, name);
            dataBase.editSubject(subject);
            return "Предмет изменен";
        } else {
            throw new NullPointerException("Такой предмет не найден в системе");
        }
    }


    @Override
    public String deleteSubject(int id) {
        Subject subject1 = dataBase.getSubjectById(id);
        if (subject1 != null) {
            dataBase.deleteSubject(id);
            return "Предмет удален";
        } else {
            throw new NullPointerException("Такой предмет не найден в системе");
        }
    }
}
