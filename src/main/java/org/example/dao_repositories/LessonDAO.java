package org.example.dao_repositories;

import org.example.model.Lesson;

import java.text.ParseException;
import java.util.ArrayList;

public interface LessonDAO {

    Lesson getLessonById(int id);

    ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException;

    ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException;

    String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException;

    String DeleteLessonsByGroup(int groupId);

    String DeleteLessonById(int lessonId);

    String DeleteLessonsByTeacher(int teacherId);

    int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException;
}
