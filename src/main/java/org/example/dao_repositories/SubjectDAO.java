package org.example.dao_repositories;

import org.example.model.Subject;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface SubjectDAO {

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int id) throws RepositoryException;

    int addSubject(String name) throws RepositoryException;

    String editSubject(int id, String name);

    String deleteSubject(int id) throws RepositoryException;
}
