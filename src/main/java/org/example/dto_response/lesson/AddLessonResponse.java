package org.example.dto_response.lesson;

import java.util.Objects;

public class AddLessonResponse {
    private int id;

    public AddLessonResponse(int id) {
        this.id = id;
    }

    public AddLessonResponse() {
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
        if (!(o instanceof AddLessonResponse response)) return false;
        return getId() == response.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
