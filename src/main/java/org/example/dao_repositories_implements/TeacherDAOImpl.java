package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;

import java.util.ArrayList;

public class TeacherDAOImpl implements TeacherDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public ArrayList<Teacher> getTeachers() {
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return dataBase.getTeacherById(id);
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) {
        Teacher teacher = new Teacher(0, firstName, middleName, lastName);
        return dataBase.addTeacher(teacher);
    }

    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) {
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
