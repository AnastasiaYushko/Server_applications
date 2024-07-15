package org.example.dto_response.subject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
public class GetSubjectByIdResponse {
    private String name;

    public GetSubjectByIdResponse(String name) {
        this.name = name;
    }

    public GetSubjectByIdResponse() {
        super();
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
