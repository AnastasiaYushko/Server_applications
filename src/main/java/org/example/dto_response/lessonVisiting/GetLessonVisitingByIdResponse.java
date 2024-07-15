package org.example.dto_response.lessonVisiting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
public class GetLessonVisitingByIdResponse {
    private String lessonVisiting;

    public GetLessonVisitingByIdResponse(String listLessonVisiting) {
        this.lessonVisiting = listLessonVisiting;
    }

    public GetLessonVisitingByIdResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonVisitingByIdResponse response)) return false;
        return Objects.equals(lessonVisiting, response.lessonVisiting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonVisiting);
    }
}
