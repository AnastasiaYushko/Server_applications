package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.LessonDAO;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class LessonDAOImpl implements LessonDAO {
    @Autowired
    private final DataBase dataBase;

    public LessonDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Lesson getLessonById(int id) throws EntityNotFoundInDataBase {
        return dataBase.getLessonById(id);
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) throws ParseException, EntityNotFoundInDataBase {
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);

        return dataBase.getLessonsByGroup(dateStartTrue, dateEndTrue, groupId);
    }

    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) throws ParseException, EntityNotFoundInDataBase {
        Date dateStartTrue = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
        Date dateEndTrue = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);

        return dataBase.getLessonsByTeacher(dateStartTrue, dateEndTrue, teacherId);
    }

    @Override
    public String EditLesson(int id, String date, int number, int teacherId, int groupId, int subjectId) throws ParseException, EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
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
    }

    @Override
    public String DeleteLessonsByGroup(int groupId) throws EntityNotFoundInDataBase {
        return dataBase.deleteLessonsByGroup(groupId);
    }

    @Override
    public String DeleteLessonById(int lessonId) throws EntityNotFoundInDataBase {
        return dataBase.deleteLessonById(lessonId);
    }

    @Override
    public String DeleteLessonsByTeacher(int teacherId) throws EntityNotFoundInDataBase {
        return dataBase.deleteLessonsByTeacher(teacherId);
    }

    @Override
    public int AddLesson(String date, int number, int teacherId, int subjectId, int groupId) throws ParseException, EntityNotFoundInDataBase, AddEntityMatchData {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = df.parse(date);

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
    }
}
