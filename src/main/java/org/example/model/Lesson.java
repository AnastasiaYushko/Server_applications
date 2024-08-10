package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Component("lesson")
public class Lesson {
    private int id;
    private Date date;
    private int number;
    private Subject subject;
    private Teacher teacher;
    private StudentGroup group;

    public Lesson(int id, Date date, int number, Teacher teacher, Subject subject, StudentGroup group) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacher = teacher;
        this.subject = subject;
        this.group = group;
    }

    public Lesson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return number == lesson.number && Objects.equals(date, lesson.date) && Objects.equals(subject, lesson.subject) && Objects.equals(teacher, lesson.teacher) && Objects.equals(group, lesson.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, number, subject, teacher, group);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date=" + date +
                ", number=" + number +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", group=" + group +
                '}';
    }
}
