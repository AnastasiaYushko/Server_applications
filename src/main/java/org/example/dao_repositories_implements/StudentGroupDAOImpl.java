package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.StudentGroupDAO;
import org.example.model.StudentGroup;

import java.util.ArrayList;

public class StudentGroupDAOImpl implements StudentGroupDAO {

    private final DataBase dataBase = DataBase.getDataBase();

    //+
    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        return dataBase.getStudentGroups();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) {
        return dataBase.getStudentGroupById(id);
    }

    @Override
    public int addStudentGroup(String name) {
        StudentGroup group = new StudentGroup(0,name);
        return dataBase.addStudentGroup(group);
    }

    @Override
    public String editStudentGroup(int id, String name) {
        dataBase.editStudentGroup(new StudentGroup(id,name));
        return "Группа изменена";
    }

    @Override
    public String deleteStudentGroup(int id) {
        dataBase.deleteStudentGroup(id);
        return "Группа удалена";
    }
}
