package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
public class GetLessonsByGroupResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByGroupResponse(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }

    public GetLessonsByGroupResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonsByGroupResponse that)) return false;
        return Objects.equals(getListLessons(), that.getListLessons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListLessons());
    }
}
