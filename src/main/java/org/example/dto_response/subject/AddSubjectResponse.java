package org.example.dto_response.subject;

import java.util.Objects;

public class AddSubjectResponse {
    private int id;

    public AddSubjectResponse(int id) {
        this.id = id;
    }

    public AddSubjectResponse() {
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
        if (!(o instanceof AddSubjectResponse that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
