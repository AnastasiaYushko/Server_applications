package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
public class LessonVisiting {
    private int id;
    private int lessonId;
    private ArrayList<String> listStudent;

    public LessonVisiting(int id, int lessonId, ArrayList<String> listStudent) {
        this.id = id;
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
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
