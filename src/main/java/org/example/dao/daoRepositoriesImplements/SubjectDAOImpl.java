package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.SubjectDAO;
import org.example.model.Subject;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
    @Autowired
    private final DataBase dataBase;

    public SubjectDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) throws EntityNotFoundInDataBase {
        return dataBase.getSubjectById(id);
    }

    @Override
    public int addSubject(String name) throws AddEntityMatchData {
        Subject subject = SpringConfig.getContext().getBean("subject", Subject.class);
        subject.setName(name);
        return dataBase.addSubject(subject);
    }

    @Override
    public String editSubject(int id, String name) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        Subject newDataSubject = SpringConfig.getContext().getBean("subject", Subject.class);
        newDataSubject.setId(id);
        newDataSubject.setName(name);

        return dataBase.editSubject(newDataSubject);
    }

    @Override
    public String deleteSubject(int id) throws EntityNotFoundInDataBase {
        return dataBase.deleteSubject(id);
    }
}
