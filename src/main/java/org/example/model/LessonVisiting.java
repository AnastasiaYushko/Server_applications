package org.example.model;

import java.util.*;

public class LessonVisiting {
    private int id;
    private int lessonId;
    private ArrayList<String> listStudent;

    public LessonVisiting(int id, int lessonId, ArrayList<String> listStudent) {
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

    public void setListStudent(ArrayList<String> listStudent) {
        this.listStudent = new ArrayList<>(listStudent);
    }

    public ArrayList<String> getListStudent() {
        return listStudent;
    }

    public void setLesson(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLesson() {
        return lessonId;
    }

    @Override
    public String toString() {
        return "LessonVisiting{" +
                "id=" + id +
                ", lessonId=" + lessonId +
                ", listStudent=" + listStudent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonVisiting that)) return false;
        return getId() == that.getId() && lessonId == that.lessonId && Objects.equals(getListStudent(), that.getListStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), lessonId, getListStudent());
    }
}
