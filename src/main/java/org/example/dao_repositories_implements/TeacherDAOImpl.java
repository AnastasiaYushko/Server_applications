package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("teacher_dao_impl")
public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<Teacher> getTeachers() {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        //  if (teacher == null){
     //       throw new NullPointerException("Такого учителя нет в системе");
      //  }
        return dataBase.getTeacherById(id);
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Teacher teacher = new Teacher(0, firstName, middleName, lastName);
        return dataBase.addTeacher(teacher);
    }

    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Teacher teacher1 = dataBase.getTeacherById(id);
        if (teacher1 != null){
            Teacher teacher = new Teacher(id, firstName, middleName, lastName);
            dataBase.editTeacher(teacher);
            return "Преподаватель изменен";
        }
        else {
            throw new NullPointerException("Такой преподаватель не найден");
        }
    }

    @Override
    public String deleteTeacher(int id) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Teacher teacher1 = dataBase.getTeacherById(id);
        if (teacher1 != null) {
            dataBase.deleteTeacher(id);
            return "Преподаватель удален";
        }
        else {
            throw new NullPointerException("Такой преподаватель не найден");
        }
    }
}
