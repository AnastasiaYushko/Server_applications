package org.example.model;

import jakarta.validation.constraints.Min;
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
    @Min(1)
    private int id;
    @Min(1)
    private int lessonId;
    private ArrayList<Student> listStudent;

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
