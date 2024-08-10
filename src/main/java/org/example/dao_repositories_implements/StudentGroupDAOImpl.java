package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.StudentGroupDAO;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class StudentGroupDAOImpl implements StudentGroupDAO {

    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        return dataBase.getStudentGroups();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) throws RepositoryException {
        try {
            DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
            return dataBase.getStudentGroupById(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addStudentGroup(String name) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        StudentGroup group = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        group.setName(name);
        try {
            return dataBase.addStudentGroup(group);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editStudentGroup(int id, String name) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        StudentGroup newDataGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        newDataGroup.setName(name);
        newDataGroup.setId(id);

        try {
            return dataBase.editStudentGroup(newDataGroup);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }

    }

    @Override
    public String deleteStudentGroup(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.deleteStudentGroup(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
