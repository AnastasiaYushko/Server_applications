package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public ArrayList<Subject> getSubjects() {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getSubjectById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addSubject(String name) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        Subject subject = SpringConfig.getContext().getBean("subject", Subject.class);
        subject.setName(name);
        try {
            return dataBase.addSubject(subject);
        } catch (AddEntityMatchData e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editSubject(int id, String name) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        Subject newDataSubject = SpringConfig.getContext().getBean("subject", Subject.class);
        newDataSubject.setId(id);
        newDataSubject.setName(name);

        try {
            return dataBase.editSubject(newDataSubject);
        } catch (EntityNotFoundInDataBase |StupidChanges | ChangesEntityLeadToConflict e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String deleteSubject(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.deleteSubject(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
