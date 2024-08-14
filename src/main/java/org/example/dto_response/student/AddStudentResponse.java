package org.example.dto_response.student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class AddStudentResponse {
    private int id;

    public AddStudentResponse(int id) {
        this.id = id;
    }

    public AddStudentResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStudentResponse that = (AddStudentResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
