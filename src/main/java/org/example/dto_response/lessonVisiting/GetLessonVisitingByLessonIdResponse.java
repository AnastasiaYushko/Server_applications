package org.example.dto_response.lessonVisiting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetLessonVisitingByLessonIdResponse {
    private String lessonVisiting;

    public GetLessonVisitingByLessonIdResponse(String listLessonVisiting) {
        this.lessonVisiting = listLessonVisiting;
    }

    public GetLessonVisitingByLessonIdResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonVisitingByLessonIdResponse response)) return false;
        return Objects.equals(lessonVisiting, response.lessonVisiting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonVisiting);
    }
}
