package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.LessonVisitingDAO;
import org.example.model.Lesson;
import org.example.model.LessonVisiting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("lesson_visiting_dao_impl")
public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        if (dataBase.getLessonById(lessonId) == null){
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = dataBase.getLessonVisitingByLessonId(lessonId);
        if (lessonVisiting == null) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }
        return lessonVisiting;
    }

    @Override
    public LessonVisiting GetLessonVisitingById(int lessonVisitingById) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingById);

        if (lessonVisiting == null) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }

        dataBase.getLessonById(lessonVisiting.getLessonId());
        return lessonVisiting;
    }

    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (lesson == null) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = new LessonVisiting(0, lessonId, students);
        if (dataBase.getLessonVisitingByLessonId(lessonId) != null) {
            throw new NullPointerException("Посещаемость данного урока уже есть в системе");
        }
        return dataBase.addLessonVisiting(lessonVisiting);
    }

    @Override
    public String EditLessonVisiting(int lessonVisitingId,int lessonId,ArrayList<String> students) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (lesson == null) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        if (dataBase.getLessonVisitingById(lessonVisitingId) == null) {
            throw new NullPointerException("Посещаемость, которую вы хотите изменить - нет в системе");
        }

        LessonVisiting lessonVisiting = new LessonVisiting(lessonVisitingId, lessonId, students);
        dataBase.editLessonVisiting(lessonVisiting);

        return "Посещаемость изменена";
    }

    @Override
    public String DeleteLessonVisitingById(int lessonVisitingId) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingId);
        if (lessonVisiting == null) {
            throw new NullPointerException("Такой посещаемости нет в системе");
        }
        dataBase.deleteLessonVisitingById(lessonVisitingId);
        return "Посещаемость удалена";
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) {
        DataBase dataBase =  app.getContext().getBean("data_base",DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (lesson == null) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = dataBase.getLessonVisitingByLessonId(lessonId);
        if (lessonVisiting == null) {
            throw new NullPointerException("Такой посещаемости нет в системе");
        }
        dataBase.deleteLessonVisitingByLessonId(lessonId);
        return "Посещаемость удалена";
    }
}
