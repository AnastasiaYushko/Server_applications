package org.example.model;

import java.util.*;

public class LessonVisiting {
    private int id;
    private int lessonId;
    private ArrayList<Student> listStudent;

    public LessonVisiting(int id, int lessonId,ArrayList<Student> listStudent){
        this.id = id;
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = new ArrayList<>(listStudent);
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setLesson(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLesson() {
        return lessonId;
    }
}
