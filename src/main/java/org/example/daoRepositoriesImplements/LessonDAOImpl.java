package org.example.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.daoRepositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Subject;
import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class LessonDAOImpl implements LessonDAO {
    @Autowired
    private final DataBase dataBase;

    public LessonDAOImpl(DataBase dataBase){
        this.dataBase =dataBase;
    }

    @Override
    public Lesson getLessonById(int id) throws RepositoryException {
        try {
            return dataBase.getLessonById(id);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException, RepositoryException {
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        try {
            return dataBase.getLessonsByGroup(dateStartTrue, dateEndTrue, groupId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException, RepositoryException {
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        try {
            return dataBase.getLessonsByTeacher(dateStartTrue, dateEndTrue, teacherId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException, RepositoryException {
        try {
            Teacher teacher = dataBase.getTeacherById(teacherId);
            StudentGroup studentGroup = dataBase.getStudentGroupById(groupId);
            Subject subject = dataBase.getSubjectById(subjectId);

            Date dateTrue = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            Lesson lesson = SpringConfig.getContext().getBean("lesson", Lesson.class);
            lesson.setId(id);
            lesson.setDate(dateTrue);
            lesson.setGroup(studentGroup);
            lesson.setTeacher(teacher);
            lesson.setSubject(subject);
            lesson.setNumber(number);

            return dataBase.editLesson(lesson);
        } catch (EntityNotFoundInDataBase | StupidChanges | ChangesEntityLeadToConflict e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonsByGroup(int groupId) throws RepositoryException {
        try {
            return dataBase.deleteLessonsByGroup(groupId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonById(int lessonId) throws RepositoryException {
        try {
            return dataBase.deleteLessonById(lessonId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonsByTeacher(int teacherId) throws RepositoryException {
        try {
            return dataBase.deleteLessonsByTeacher(teacherId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException, RepositoryException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = df.parse(date);
        try {
            Teacher teacher = dataBase.getTeacherById(teacherId);
            StudentGroup group = dataBase.getStudentGroupById(groupId);
            Subject subject = dataBase.getSubjectById(subjectId);

            Lesson lesson = SpringConfig.getContext().getBean("lesson", Lesson.class);
            lesson.setDate(date1);
            lesson.setGroup(group);
            lesson.setTeacher(teacher);
            lesson.setSubject(subject);
            lesson.setNumber(number);

            return dataBase.addLesson(lesson);
        } catch (AddEntityMatchData | EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
