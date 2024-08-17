package org.example.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.daoRepositories.TeacherDAO;
import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;

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
    public Teacher getTeacherById(int id) throws RepositoryException {
        try {
            return dataBase.getTeacherById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) throws RepositoryException {
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setMiddleName(middleName);

        try {
            return dataBase.addTeacher(teacher);
        } catch (AddEntityMatchData e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) throws RepositoryException {
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setId(id);
        teacher.setFirstName(firstName);
        teacher.setMiddleName(middleName);
        teacher.setLastName(lastName);

        try {
            return dataBase.editTeacher(teacher);
        } catch (EntityNotFoundInDataBase | StupidChanges | ChangesEntityLeadToConflict e) {
            throw new RepositoryException(e.getMessage());
        }

    }

    @Override
    public String deleteTeacher(int id) throws RepositoryException {
        try {
            return dataBase.deleteTeacher(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
