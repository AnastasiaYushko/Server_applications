package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("subject_dao_impl")
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public ArrayList<Subject> getSubjects() {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Subject subject = dataBase.getSubjectById(id);
        if (subject == null){
            throw new NullPointerException("Такого предмета нет в системе");
        }
        return subject;
    }

    @Override
    public int addSubject(String name) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Subject subject = new Subject(0, name);
        return dataBase.addSubject(subject);
    }

    @Override
    public String editSubject(int id, String name) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
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
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Subject subject1 = dataBase.getSubjectById(id);
        if (subject1 != null) {
            dataBase.deleteSubject(id);
            return "Предмет удален";
        } else {
            throw new NullPointerException("Такой предмет не найден в системе");
        }
    }
}
