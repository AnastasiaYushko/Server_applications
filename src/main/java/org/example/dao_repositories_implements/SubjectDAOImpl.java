package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Repository("subject_dao_impl")
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public ArrayList<Subject> getSubjects() {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject subject = dataBase.getSubjectById(id);
        if (isNull(subject)) {
            throw new NullPointerException("Такого предмета нет в системе");
        }
        return subject;
    }

    @Override
    public int addSubject(String name) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject subject = SpringConfig.getContext().getBean("subject", Subject.class);
        subject.setName(name);
        int result = dataBase.addSubject(subject);
        if (result == -1) {
            throw new NullPointerException("Такой предмет уже есть в системе");
        }
        return result;
    }

    @Override
    public String editSubject(int id, String name) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject subject = dataBase.getSubjectById(id);
        if (!isNull(subject)) {
            Subject newDataSubject = SpringConfig.getContext().getBean("subject", Subject.class);
            newDataSubject.setId(id);
            newDataSubject.setName(name);
            dataBase.editSubject(newDataSubject);
            return "Предмет изменен";
        } else {
            throw new NullPointerException("Такой предмет не найден в системе");
        }
    }

    @Override
    public String deleteSubject(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject subject = dataBase.getSubjectById(id);
        if (!isNull(subject)) {
            dataBase.deleteSubject(id);
            return "Предмет удален";
        } else {
            throw new NullPointerException("Такой предмет не найден в системе");
        }
    }
}
