package org.example.model;

import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Objects;

public class Lesson {
    private int id;
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d)")
    private String date;
    @Positive
    private int number;
    @NotNull
    private Teacher teacher;
    @NotNull
    private StudentGroup group;

    public Lesson(int id, String date, int number, @NotNull Teacher teacher, @NotNull StudentGroup group) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacher = teacher;
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroup(@NotNull StudentGroup group) {
        this.group = group;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTeacher(@NotNull Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public @NotNull StudentGroup getGroup() {
        return group;
    }

    public @NotNull Teacher getTeacher() {
        return teacher;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date=" + date +
                ", number=" + number +
                ", teacher=" + teacher +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson lesson)) return false;
        return getId() == lesson.getId() && getNumber() == lesson.getNumber() && getDate().equals(lesson.getDate()) && getTeacher().equals(lesson.getTeacher()) && getGroup().equals(lesson.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getNumber(), getTeacher(), getGroup());
    }
}
