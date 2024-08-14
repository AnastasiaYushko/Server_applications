package org.example.dto_response.studentGroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class AddStudentGroupResponse {
    private int id;

    public AddStudentGroupResponse(int id) {
        this.id = id;
    }

    public AddStudentGroupResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStudentGroupResponse that = (AddStudentGroupResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
