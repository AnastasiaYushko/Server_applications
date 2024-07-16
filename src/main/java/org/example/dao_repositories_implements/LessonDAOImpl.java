package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.app;
import org.example.dao_repositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Subject;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.util.Objects.isNull;

@Repository
public class LessonDAOImpl implements LessonDAO {

    @Override
    public Lesson getLessonById(int id) {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        Lesson lesson = dataBase.getLessonById(id);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в системе");
        }
        return lesson;
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        if (!isNull(group)) {
            Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            return dataBase.getLessonsByGroup(dateStartTrue, dateEndTrue, group);
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }

    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (!isNull(teacher)) {
            Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            return dataBase.getLessonsByTeacher(dateStartTrue, dateEndTrue, teacher);
        } else {
            throw new NullPointerException("Такого учителя нет в системе");
        }
    }

    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (isNull(teacher)) {
            throw new NullPointerException("Такого учителя нет в системе");
        }
        StudentGroup studentGroup = dataBase.getStudentGroupById(groupId);
        if (isNull(studentGroup)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        if (isNull(dataBase.getLessonById(id))) {
            throw new NullPointerException("Такого урока нет в системе");
        }
        Subject subject = dataBase.getSubjectById(subjectId);
        if (isNull(subject)) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        Date dateTrue = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Lesson lesson = app.getContext().getBean("lesson", Lesson.class);
        lesson.setId(id);
        lesson.setDate(dateTrue);
        lesson.setGroup(studentGroup);
        lesson.setTeacher(teacher);
        lesson.setSubject(subject);
        lesson.setNumber(number);

        dataBase.EditLesson(lesson);

        return "Данные урока изменены!";
    }

    @Override
    public String DeleteLessonsByGroup(int groupId) {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        dataBase.DeleteLessonsByGroup(groupId);
        return "Уроки у группы удалены!";
    }

    @Override
    public String DeleteLessonById(int lessonId) {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в системе");
        }
        dataBase.DeleteLessonById(lessonId);
        return "Урок удален";
    }

    @Override
    public String DeleteLessonsByTeacher(int teacherId) {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (isNull(teacher)) {
            throw new NullPointerException("Такого учителя нет в системе");
        }
        dataBase.DeleteLessonsByTeacher(teacherId);
        return "Урок удален";
    }

    @Override
    public int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException {
        DataBase dataBase = app.getContext().getBean("data_base", DataBase.class);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = df.parse(date);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        Subject subject = dataBase.getSubjectById(subjectId);
        Lesson lesson = new Lesson(0, date1, number, teacher, subject, group);

        return dataBase.AddLesson(lesson);
    }
}
