package org.example.dao_repositories;

import org.example.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface SubjectDAO {

    ArrayList<Subject> getSubjects();

    Subject getSubjectById(int id);

    int addSubject(String name);

    String editSubject(int id, String name);

    String deleteSubject(int id);
}
