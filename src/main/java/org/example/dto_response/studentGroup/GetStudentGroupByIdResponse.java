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
public class GetStudentGroupByIdResponse {
    private String name;

    public GetStudentGroupByIdResponse(String name) {
        this.name = name;
    }

    public GetStudentGroupByIdResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentGroupByIdResponse that = (GetStudentGroupByIdResponse) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
