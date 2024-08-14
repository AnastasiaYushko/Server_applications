package org.example.dto_response.teacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class AddTeacherResponse {
    private int id;

    public AddTeacherResponse(int id) {
        this.id = id;
    }

    public AddTeacherResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTeacherResponse that = (AddTeacherResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
