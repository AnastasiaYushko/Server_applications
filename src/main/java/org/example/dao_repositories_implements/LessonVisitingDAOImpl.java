package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.LessonVisitingDAO;
import org.example.model.Lesson;
import org.example.model.LessonVisiting;

import java.util.ArrayList;

public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) {

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
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingById);

        if (lessonVisiting == null) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }

        dataBase.getLessonById(lessonVisiting.getLesson());
        return lessonVisiting;
    }

    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students) {
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
        LessonVisiting lessonVisiting = dataBase.getLessonVisitingById(lessonVisitingId);
        if (lessonVisiting == null) {
            throw new NullPointerException("Такой посещаемости нет в системе");
        }
        dataBase.deleteLessonVisitingById(lessonVisitingId);
        return "Посещаемость удалена";
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) {

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
