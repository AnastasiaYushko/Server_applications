package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.TeacherDAO;
import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    @Autowired
    private final DataBase dataBase;

    public TeacherDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<Teacher> getTeachers() {
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) throws EntityNotFoundInDataBase {
        return dataBase.getTeacherById(id);
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) throws AddEntityMatchData {
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setMiddleName(middleName);

        return dataBase.addTeacher(teacher);
    }

    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) throws  StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setId(id);
        teacher.setFirstName(firstName);
        teacher.setMiddleName(middleName);
        teacher.setLastName(lastName);

        return dataBase.editTeacher(teacher);
    }

    @Override
    public String deleteTeacher(int id) throws EntityNotFoundInDataBase {
        return dataBase.deleteTeacher(id);
    }
}
