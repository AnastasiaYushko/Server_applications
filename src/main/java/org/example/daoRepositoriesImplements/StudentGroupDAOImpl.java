package org.example.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.daoRepositories.StudentGroupDAO;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class StudentGroupDAOImpl implements StudentGroupDAO {
    @Autowired
    private final DataBase dataBase;

    public StudentGroupDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        return dataBase.getStudentGroups();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) throws RepositoryException {
        try {
            return dataBase.getStudentGroupById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addStudentGroup(String name) throws RepositoryException {
        StudentGroup group = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        group.setName(name);
        try {
            return dataBase.addStudentGroup(group);
        } catch (AddEntityMatchData e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editStudentGroup(int id, String name) throws RepositoryException {
        StudentGroup newDataGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        newDataGroup.setName(name);
        newDataGroup.setId(id);
        try {
            return dataBase.editStudentGroup(newDataGroup);
        } catch (EntityNotFoundInDataBase | StupidChanges | ChangesEntityLeadToConflict e) {
            throw new RepositoryException(e.getMessage());
        }

    }

    @Override
    public String deleteStudentGroup(int id) throws RepositoryException {
        try {
            return dataBase.deleteStudentGroup(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
