package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonsByTeacherResponse that)) return false;
        return Objects.equals(getListLessons(), that.getListLessons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListLessons());
    }
}
