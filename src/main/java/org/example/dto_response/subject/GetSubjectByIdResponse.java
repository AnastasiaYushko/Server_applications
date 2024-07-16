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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSubjectByIdResponse that = (GetSubjectByIdResponse) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
