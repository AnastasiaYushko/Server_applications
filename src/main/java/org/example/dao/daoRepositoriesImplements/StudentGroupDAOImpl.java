package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.StudentGroupDAO;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public StudentGroup getStudentGroupById(int id) throws EntityNotFoundInDataBase {
        return dataBase.getStudentGroupById(id);
    }

    @Override
    public int addStudentGroup(String name) throws AddEntityMatchData {
        StudentGroup group = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        group.setName(name);
        return dataBase.addStudentGroup(group);
    }

    @Override
    public String editStudentGroup(int id, String name) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        StudentGroup newDataGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        newDataGroup.setName(name);
        newDataGroup.setId(id);
        return dataBase.editStudentGroup(newDataGroup);
    }

    @Override
    public String deleteStudentGroup(int id) throws EntityNotFoundInDataBase {
        return dataBase.deleteStudentGroup(id);
    }
}
