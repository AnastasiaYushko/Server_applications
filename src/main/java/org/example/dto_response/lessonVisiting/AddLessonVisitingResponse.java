package org.example.dto_response.lessonVisiting;

import java.util.Objects;

public class AddLessonVisitingResponse {
    private int id;

    public AddLessonVisitingResponse(int id) {
        this.id = id;
    }

    public AddLessonVisitingResponse() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
