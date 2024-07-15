package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
public class AddLessonResponse {
    private int id;

    public AddLessonResponse(int id) {
        this.id = id;
    }

    public AddLessonResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddLessonResponse response)) return false;
        return getId() == response.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
