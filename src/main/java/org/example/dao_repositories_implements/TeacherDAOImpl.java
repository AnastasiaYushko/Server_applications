package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.TeacherDAO;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository("teacher_dao_impl")
public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public ArrayList<Teacher> getTeachers() {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        return dataBase.getTeachers();
    }

    @Override
    public Teacher getTeacherById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.getTeacherById(id);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public int addTeacher(String firstName, String middleName, String lastName) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setMiddleName(middleName);

        try {
            return dataBase.addTeacher(teacher);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public String editTeacher(int id, String firstName, String middleName, String lastName) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);

            Teacher teacher = SpringConfig.getContext().getBean("teacher", Teacher.class);
            teacher.setId(id);
            teacher.setFirstName(firstName);
            teacher.setMiddleName(middleName);
            teacher.setLastName(lastName);

            try {
                return dataBase.editTeacher(teacher);
            }
            catch (NullPointerException e){
                throw new RepositoryException(e);
            }

    }

    @Override
    public String deleteTeacher(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);

        try {
            return dataBase.deleteTeacher(id);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }
}
