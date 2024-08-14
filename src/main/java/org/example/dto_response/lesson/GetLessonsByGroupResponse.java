package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetLessonsByGroupResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByGroupResponse(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }

    public GetLessonsByGroupResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonsByGroupResponse that = (GetLessonsByGroupResponse) o;
        return Objects.equals(listLessons, that.listLessons);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(listLessons);
    }
}
