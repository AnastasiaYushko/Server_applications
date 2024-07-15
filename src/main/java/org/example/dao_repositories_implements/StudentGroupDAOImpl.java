package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.StudentGroupDAO;
import org.example.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("student_group_dao_impl")
public class StudentGroupDAOImpl implements StudentGroupDAO {

    @Override
    public ArrayList<StudentGroup> getStudentGroups() {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        return dataBase.getStudentGroups();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
         if (group == null){
            throw new NullPointerException("Такой группы нет в системе");
        }
        return group;
    }

    @Override
    public int addStudentGroup(String name) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = new StudentGroup(0, name);
        return dataBase.addStudentGroup(group);
    }

    @Override
    public String editStudentGroup(int id, String name) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
        if (group != null) {
            dataBase.editStudentGroup(new StudentGroup(id, name));
            return "Группа изменена";
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }

    @Override
    public String deleteStudentGroup(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(id);
        if (group != null) {
            dataBase.deleteStudentGroup(id);
            return "Группа удалена";
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }
}
