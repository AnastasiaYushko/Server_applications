package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.LessonVisitingDAO;
import org.example.model.LessonVisiting;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getLessonVisitingByLessonId(lessonId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public LessonVisiting GetLessonVisitingById(int lessonVisitingById) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);
        try {
            return dataBase.getLessonVisitingById(lessonVisitingById);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setLessonId(lessonId);
        lessonVisiting.setListStudent(students);

        try {
            return dataBase.addLessonVisiting(lessonVisiting);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setId(lessonVisitingId);
        lessonVisiting.setLessonId(lessonId);
        lessonVisiting.setListStudent(students);

        try {
            return dataBase.editLessonVisiting(lessonVisiting);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonVisitingById(int lessonVisitingId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        try {
            return dataBase.deleteLessonVisitingById(lessonVisitingId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("dataBase", DataBase.class);

        try {
            return dataBase.deleteLessonVisitingByLessonId(lessonId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
