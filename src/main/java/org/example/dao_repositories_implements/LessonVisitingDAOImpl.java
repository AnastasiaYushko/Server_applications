package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.LessonVisitingDAO;
import org.example.model.Lesson;
import org.example.model.LessonVisiting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Repository("lesson_visiting_dao_impl")
public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        if (isNull(dataBase.getLessonById(lessonId))) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = dataBase.getLessonVisitingByLessonId(lessonId);
        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }
        return lessonVisiting;
    }

    @Override
    public LessonVisiting GetLessonVisitingById(int lessonVisitingById) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingById);

        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }

        return lessonVisiting;
    }

    // исключить добавление одинаковых
    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setLessonId(lessonId);
        lessonVisiting.setListStudent(students);
        if (!isNull(dataBase.getLessonVisitingByLessonId(lessonId))) {
            throw new NullPointerException("Посещаемость данного урока уже есть в системе");
        }
        return dataBase.addLessonVisiting(lessonVisiting);
    }

    ////при изменении чтобы не было одинаковых
    @Override
    public String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        if (isNull(dataBase.getLessonVisitingById(lessonVisitingId))) {
            throw new NullPointerException("Посещаемость, которую вы хотите изменить - нет в системе");
        }

        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setId(lessonVisitingId);
        lessonVisiting.setLessonId(lessonId);
        lessonVisiting.setListStudent(students);

        dataBase.editLessonVisiting(lessonVisiting);

        return "Посещаемость изменена";
    }

    @Override
    public String DeleteLessonVisitingById(int lessonVisitingId) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingId);
        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Такой посещаемости нет в системе");
        }
        dataBase.deleteLessonVisitingById(lessonVisitingId);
        return "Посещаемость удалена";
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        LessonVisiting lessonVisiting = dataBase.getLessonVisitingByLessonId(lessonId);
        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Такой посещаемости нет в системе");
        }
        dataBase.deleteLessonVisitingByLessonId(lessonId);
        return "Посещаемость удалена";
    }
}
