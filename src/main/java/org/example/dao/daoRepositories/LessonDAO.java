package org.example.dao.daoRepositories;

import org.example.model.Lesson;
import javax.jcr.RepositoryException;
import java.text.ParseException;
import java.util.ArrayList;

public interface LessonDAO {

    Lesson getLessonById(int id) throws RepositoryException;

    ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException, RepositoryException;

    ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException, RepositoryException;

    String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException, RepositoryException;

    String DeleteLessonsByGroup(int groupId) throws RepositoryException;

    String DeleteLessonById(int lessonId) throws RepositoryException;

    String DeleteLessonsByTeacher(int teacherId) throws RepositoryException;

    int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException, RepositoryException;
}
