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
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddLessonVisitingResponse that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
