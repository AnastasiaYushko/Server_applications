package org.example.daoRepositories;

import org.example.model.StudentGroup;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface StudentGroupDAO {

    ArrayList<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroupById(int groupId) throws RepositoryException;

    int addStudentGroup(String name) throws RepositoryException;

    String editStudentGroup(int id, String name) throws RepositoryException;

    String deleteStudentGroup(int id) throws RepositoryException;
}
