package org.example.dto_response.subject;

import java.util.Objects;

public class GetSubjectByIdResponse {
    private String name;

    public GetSubjectByIdResponse(String name) {
        this.name = name;
    }

    public GetSubjectByIdResponse() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSubjectByIdResponse that)) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
