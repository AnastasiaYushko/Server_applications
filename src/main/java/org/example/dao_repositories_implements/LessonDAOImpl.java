package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Teacher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LessonDAOImpl implements LessonDAO {

    DataBase dataBase = DataBase.getDataBase();

    @Override
    public Lesson getLessonById(int id) {
        Lesson lesson =dataBase.getLessonById(id);
        if (lesson == null){
            throw new NullPointerException("Такого урока нет в системе");
        }
        return lesson;
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException {
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        if (group != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = df.parse(startDate);
            Date date2 = df.parse(endDate);
            return dataBase.getLessonsByGroup(date1, date2, group);
        } else {
            throw new NullPointerException("Такой группы нет в системе");
        }
    }

    //+!
    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException {
        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (teacher != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = df.parse(startDate);
            Date date2 = df.parse(endDate);
            return dataBase.getLessonsByTeacher(date1, date2, teacher);
        } else {
            throw new NullPointerException("Такого учителя нет в системе");
        }
    }

    //+!
    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId) throws ParseException {

        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (teacher == null) {
            throw new NullPointerException("Такого учителя нет в системе");
        }
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        if (group == null) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        Lesson lesson = dataBase.getLessonById(id);
        if (lesson == null) {
            throw new NullPointerException("Такого урока нет в системе");
        }

        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        dataBase.EditLesson(new Lesson(id, date1, number, teacher, group));
        return "Данные урока изменены!";
    }

    //+!
    @Override
    public String DeleteLessonsByGroup(int groupId) {
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        if (group == null) {
            throw new NullPointerException("Такой группы нет в системе");
        }
        dataBase.DeleteLessonsByGroup(groupId);
        return "Уроки у группы удалены!";
    }

    //+!
    @Override
    public String DeleteLessonById(int lessonId) {
        Lesson lesson = dataBase.getLessonById(lessonId);
        if (lesson == null) {
            throw new NullPointerException("Такого урока нет в системе");
        }
        dataBase.DeleteLessonById(lessonId);
        return "Урок удален";
    }

    //+!
    @Override
    public String DeleteLessonsByTeacher(int teacherId) {
        Teacher teacher = dataBase.getTeacherById(teacherId);
        if (teacher == null) {
            throw new NullPointerException("Такого учителя нет в системе");
        }
        dataBase.DeleteLessonsByTeacher(teacherId);
        return "Урок удален";
    }

    //+!
    @Override
    public int AddLesson(String date, int number, int teacherId, int groupId) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = df.parse(date);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        Lesson lesson = new Lesson(0, date1, number, teacher, group);

        return dataBase.AddLesson(lesson);
    }
}
