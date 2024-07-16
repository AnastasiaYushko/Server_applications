package org.example.dto_response.lessonVisiting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
public class AddLessonVisitingResponse {
    private int id;

    public AddLessonVisitingResponse(int id) {
        this.id = id;
    }

    public AddLessonVisitingResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddLessonVisitingResponse that = (AddLessonVisitingResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
