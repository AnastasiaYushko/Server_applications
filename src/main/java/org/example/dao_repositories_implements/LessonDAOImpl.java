package org.example.dao_repositories_implements;

import org.example.dao_repositories.LessonDAO;
import org.example.model.Lesson;
import org.example.model.StudentGroup;
import org.example.model.Teacher;

import java.util.ArrayList;

public class LessonDAOImpl implements LessonDAO {
    @Override
    public Lesson getLessonById(int id) {
        //Возвращает конкретный объект Lesson
        Teacher  teacher = new Teacher(2,"Иван","Леонидович","Иванов");
        StudentGroup group = new StudentGroup(3,"ММБ-104-02");
        //
        return new Lesson(id,"01-12-2023",2,teacher,group);
    }

    @Override
    public ArrayList<Lesson> getLessonsByGroup(String startDate, String endDate, int groupId) {
        //Возвращает массив конкретных объектов Lesson
        Teacher teacher = new Teacher(2, "Иван", "Леонидович", "Иванов");
        StudentGroup group = new StudentGroup(groupId, "ММБ-104-02");
        ArrayList<Lesson> lessons = new ArrayList<>();
        Lesson lesson1 = new Lesson(0, "01-12-2023", 2, teacher, group);
        Lesson lesson2 = new Lesson(1, "02-12-2023", 3, teacher, group);
        lessons.add(lesson1);
        lessons.add(lesson2);
        //
        return lessons;
    }

    @Override
    public ArrayList<Lesson> getLessonsByTeacher(String startDate, String endDate, int teacherId) {
        //Возвращает массив конкретных объектов Lesson
        Teacher teacher = new Teacher(teacherId, "Иван", "Леонидович", "Иванов");
        StudentGroup group = new StudentGroup(1, "ММБ-104-02");
        ArrayList<Lesson> lessons = new ArrayList<>();
        Lesson lesson1 = new Lesson(0, "01-12-2023", 2, teacher, group);
        Lesson lesson2 = new Lesson(1, "02-12-2023", 3, teacher, group);
        lessons.add(lesson1);
        lessons.add(lesson2);
        //
        return lessons;
    }

    @Override
    public void EditLessonRequest(int id, String date, int number, int teacherId, int groupId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Урок изменен");
    }

    @Override
    public void DeleteLessonsByGroup(int groupId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Урок у группы удален");
    }

    @Override
    public void DeleteLessonsById(int lessonId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Урок удален");
    }

    @Override
    public void DeleteLessonsByTeacher(int teacherId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Урок у преподавателя удален");
    }

    @Override
    public void AddLesson(String date, int number, int teacherId, int groupId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Урок добавлен");
    }
}
