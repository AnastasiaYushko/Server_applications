package org.example.dao_repositories_implements;

import org.example.DataBase;
import org.example.dao_repositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LessonDAOImpl implements LessonDAO {

    DataBase dataBase = DataBase.getDataBase();

    //+!
    @Override
    public Lesson getLessonById(int id) {
        return dataBase.getLessonById(id);
    }

    //+!
    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        return dataBase.getLessonsByGroup(date1,date2,group);
    }

    //+!
    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException{
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        return dataBase.getLessonsByTeacher(date1,date2,teacher);
    }

    //+!
    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        dataBase.EditLesson(new Lesson(id,date1,number,teacher,group));
        return "Данные урока изменены!";
    }

    //+!
    @Override
    public String DeleteLessonsByGroup(int groupId) {
        dataBase.DeleteLessonsByGroup(groupId);
        return "Уроки у группы удалены!";
    }

    //+!
    @Override
    public String DeleteLessonById(int lessonId) {
        dataBase.DeleteLessonById(lessonId);
        return "Урок удален";
    }

    //+!
    @Override
    public String DeleteLessonsByTeacher(int teacherId) {
        dataBase.DeleteLessonsByTeacher(teacherId);
        return "Урок удален";
    }

    //+!
    @Override
    public int AddLesson(String date, int number, int teacherId, int groupId) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Teacher teacher = dataBase.getTeacherById(teacherId);
        StudentGroup group = dataBase.getStudentGroupById(groupId);
        Lesson lesson = new Lesson(0,date1,number,teacher,group);

        return dataBase.AddLesson(lesson);
    }
}
