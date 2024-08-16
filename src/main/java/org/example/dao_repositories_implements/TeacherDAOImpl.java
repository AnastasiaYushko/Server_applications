package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<Teacher> getTeachers() {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getTeacherById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
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
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

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
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        try {
            return dataBase.deleteTeacher(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
