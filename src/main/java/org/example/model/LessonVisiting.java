package org.example.model;

import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Scope("prototype")
public class LessonVisiting {
    @Positive
    private int id;
    @Positive
    private int lessonId;
    private ArrayList<Student> listStudent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonVisiting that = (LessonVisiting) o;
        return id == that.id && lessonId == that.lessonId && Objects.equals(listStudent, that.listStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, listStudent);
    }

    public boolean equalsWithoutId(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonVisiting that = (LessonVisiting) o;
        return lessonId == that.lessonId && Objects.equals(listStudent, that.listStudent);
    }
}
