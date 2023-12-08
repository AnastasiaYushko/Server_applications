package org.example.dao_repositories;

import org.example.model.Subject;

import java.util.ArrayList;

public interface SubjectDAO {

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int id);

    void addSubject(String name);

    void editSubject(int id,String name);

    void deleteSubject(int id);
}
