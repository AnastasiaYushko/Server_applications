package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component("lessonVisiting")
public class LessonVisiting {
    private int id;
    private int lessonId;
    private ArrayList<String> listStudent;

    public LessonVisiting(int id, int lessonId, ArrayList<String> listStudent) {
        this.id = id;
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
    }

    public LessonVisiting() {
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
        if (o == null || getClass() != o.getClass()) return false;
        LessonVisiting that = (LessonVisiting) o;
        return lessonId == that.lessonId && Objects.equals(listStudent, that.listStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, listStudent);
    }
}
