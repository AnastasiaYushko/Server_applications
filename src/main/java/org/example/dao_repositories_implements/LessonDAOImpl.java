package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao_repositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Subject;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class LessonDAOImpl implements LessonDAO {

    @Override
    public Lesson getLessonById(int id) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.getLessonById(id);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException, RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        try {
            return dataBase.getLessonsByGroup(dateStartTrue, dateEndTrue, groupId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException, RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        try {
            return dataBase.getLessonsByTeacher(dateStartTrue, dateEndTrue, teacherId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException, RepositoryException {

        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);

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

            return dataBase.EditLesson(lesson);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public String DeleteLessonsByGroup(int groupId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.DeleteLessonsByGroup(groupId);
        } catch (NullPointerException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public String DeleteLessonById(int lessonId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.DeleteLessonById(lessonId);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public String DeleteLessonsByTeacher(int teacherId) throws RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
        try {
            return dataBase.DeleteLessonsByTeacher(teacherId);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException, RepositoryException {
        DataBase dataBase = SpringConfig.getContext().getBean("data_base", DataBase.class);
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

            return dataBase.AddLesson(lesson);
        }
        catch (NullPointerException e){
            throw new RepositoryException(e);
        }
    }
}
