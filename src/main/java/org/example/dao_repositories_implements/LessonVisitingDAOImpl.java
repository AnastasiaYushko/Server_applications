package org.example.dao_repositories_implements;

import org.example.dao_repositories.LessonVisitingDAO;
import org.example.enums.StatusStudent;
import org.example.model.*;

import java.util.ArrayList;

public class LessonVisitingDAOImpl implements LessonVisitingDAO {

    @Override
    public LessonVisiting GetLessonVisitingRequest(int lessonId) {
        //Возвращает конкретный объект LessonVisiting
        StudentGroup group = new StudentGroup(2, "ММБ-104-02");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1,"Романов","Евгений","Ильич",statusStudent,group);
        Student student2 = new Student(2,"Романова","Евгений","Ильинична",statusStudent,group);
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        return new LessonVisiting(2,lessonId,arrayList);
        //
    }

    @Override
    public void AddLessonVisiting(int lessonId, ArrayList<Student> students) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Посещаемость к уроку добавлена");
    }

    @Override
    public void DeleteLessonVisitingRequest(int lessonId) {
        //Ничего не делает (выводит сообщение на консоль)
        System.out.println("Посещаемость у урока удалена");
    }
}
