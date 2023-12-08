package org.example.dao_repositories;

import org.example.model.Lesson;

import java.util.ArrayList;

//без посещаемости
public interface LessonDAO {

    Lesson getLessonById(int id);

    ArrayList<Lesson> getLessonsByGroup( String startDate, String endDate, int groupId);

    ArrayList<Lesson> getLessonsByTeacher( String startDate, String endDate, int teacherId);

    void EditLessonRequest(int id, String date, int number, int teacherId, int groupId);

    void DeleteLessonsByGroup(int groupId);

    void DeleteLessonsById(int lessonId);

    void DeleteLessonsByTeacher(int teacherId);

    void AddLesson(String date, int number, int teacherId, int groupId);
}
