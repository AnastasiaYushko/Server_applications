package org.example.dao.daoRepositories;

import org.example.model.Subject;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface SubjectDAO {

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int id) throws RepositoryException, EntityNotFoundInDataBase;

    int addSubject(String name) throws RepositoryException, AddEntityMatchData;

    String editSubject(int id, String name) throws RepositoryException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    String deleteSubject(int id) throws RepositoryException, EntityNotFoundInDataBase;
}
