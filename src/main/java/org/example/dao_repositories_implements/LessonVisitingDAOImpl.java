package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.LessonVisitingDAO;
import org.example.model.LessonVisiting;

import java.util.ArrayList;

public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public LessonVisiting GetLessonVisiting(int lessonId) {
        return dataBase.getLessonVisiting(lessonId);
    }

    @Override
    public String AddLessonVisiting(int lessonId, ArrayList<String> students) {

        LessonVisiting lessonVisiting = new LessonVisiting(0, lessonId, students);
        dataBase.addLessonVisiting(lessonVisiting);
        return "Посещаемость урока добавлена!";
    }

    @Override
    public String DeleteLessonVisiting(int lessonId) {
        dataBase.deleteLessonVisiting(lessonId);
        return "Посещаемость данного урока удалена!";
    }
}
