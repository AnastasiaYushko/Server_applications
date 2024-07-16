package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
public class GetLessonsByTeacherResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByTeacherResponse(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }

    public GetLessonsByTeacherResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonsByTeacherResponse that = (GetLessonsByTeacherResponse) o;
        return Objects.equals(listLessons, that.listLessons);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(listLessons);
    }
}
