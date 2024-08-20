package org.example.dao.daoRepositories;

import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface StudentGroupDAO {

    ArrayList<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroupById(int groupId) throws RepositoryException, EntityNotFoundInDataBase;

    int addStudentGroup(String name) throws RepositoryException, AddEntityMatchData;

    String editStudentGroup(int id, String name) throws RepositoryException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    String deleteStudentGroup(int id) throws RepositoryException, EntityNotFoundInDataBase;
}
