package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;

import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {

    private final DataBase dataBase = DataBase.getDataBase();

    //+!
    @Override
    public ArrayList<Subject> getSubjects() {
        return dataBase.getSubjects();
    }

    //+!
    @Override
    public Subject getSubjectById(int id) {
        return dataBase.getSubjectById(id);
    }

    //+!
    @Override
    public int addSubject(String name) {
        Subject subject = new Subject(0, name);
        return dataBase.addSubject(subject);
    }

    //+!
    @Override
    public String editSubject(int id, String name) {
        Subject subject = new Subject(id, name);
        dataBase.editSubject(subject);
        return "Предмет изменен";
    }

    //+!
    @Override
    public String deleteSubject(int id) {
        dataBase.deleteSubject(id);
        return "Предмет удален";
    }
}
