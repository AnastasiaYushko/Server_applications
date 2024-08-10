package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.SubjectDAO;
import org.example.model.Subject;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository("subject_dao_impl")
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public ArrayList<Subject> getSubjects() {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        return dataBase.getSubjects();
    }

    @Override
    public Subject getSubjectById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.getSubjectById(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public int addSubject(String name) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject subject = SpringConfig.getContext().getBean("subject", Subject.class);
        subject.setName(name);
        try {
            return dataBase.addSubject(subject);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public String editSubject(int id, String name) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Subject newDataSubject = SpringConfig.getContext().getBean("subject", Subject.class);
        newDataSubject.setId(id);
        newDataSubject.setName(name);

        return dataBase.editSubject(newDataSubject);
    }

    @Override
    public String deleteSubject(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.deleteSubject(id);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }
}
