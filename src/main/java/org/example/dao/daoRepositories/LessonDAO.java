package org.example.dao.daoRepositories;

import org.example.model.Lesson;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.text.ParseException;
import java.util.ArrayList;

public interface LessonDAO {

    Lesson getLessonById(int id) throws RepositoryException, EntityNotFoundInDataBase;

    ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException, RepositoryException, EntityNotFoundInDataBase;

    ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException, RepositoryException, EntityNotFoundInDataBase;

    String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException, RepositoryException, EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict;

    String DeleteLessonsByGroup(int groupId) throws RepositoryException, EntityNotFoundInDataBase;

    String DeleteLessonById(int lessonId) throws RepositoryException, EntityNotFoundInDataBase;

    String DeleteLessonsByTeacher(int teacherId) throws RepositoryException, EntityNotFoundInDataBase;

    int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException, RepositoryException, EntityNotFoundInDataBase, AddEntityMatchData;
}
