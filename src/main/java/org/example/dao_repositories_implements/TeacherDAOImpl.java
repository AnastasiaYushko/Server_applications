package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Repository("teacher_dao_impl")
public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<Teacher> getTeachers() {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(id);
        if (isNull(teacher)) {
            throw new NullPointerException("Такого учителя нет в системе");
        }
        return teacher;
    }

    //исключить повторы
    @Override
    public int addTeacher(String firstName, String middleName, String lastName) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setMiddleName(middleName);
        return dataBase.addTeacher(teacher);
    }

    //исключить повторы
    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(id);
        if (!isNull(teacher)) {
            Teacher newDataTeacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
            newDataTeacher.setId(id);
            newDataTeacher.setFirstName(firstName);
            newDataTeacher.setMiddleName(middleName);
            newDataTeacher.setLastName(lastName);
            dataBase.editTeacher(newDataTeacher);
            return "Преподаватель изменен";
        } else {
            throw new NullPointerException("Такой преподаватель не найден");
        }
    }

    @Override
    public String deleteTeacher(int id) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(id);
        if (!isNull(teacher)) {
            dataBase.deleteTeacher(id);
            return "Преподаватель удален";
        } else {
            throw new NullPointerException("Такой преподаватель не найден");
        }
    }
}
