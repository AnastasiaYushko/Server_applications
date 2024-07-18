package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.StudentGroupDAO;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Repository("student_group_dao_impl")
public class StudentGroupDAOImpl implements StudentGroupDAO {

    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        return dataBase.getStudentGroups();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        return group;
    }

    @Override
    public int addStudentGroup(String name) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        group.setName(name);
        return dataBase.addStudentGroup(group);
    }

    @Override
    public String editStudentGroup(int id, String name) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
        if (!isNull(group)) {
            StudentGroup newDataGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
            newDataGroup.setName(name);
            newDataGroup.setId(id);
            dataBase.editStudentGroup(newDataGroup);
            return "Группа изменена";
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }

    @Override
    public String deleteStudentGroup(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
        if (!isNull(group)) {
            dataBase.deleteStudentGroup(id);
            return "Группа удалена";
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }
}
