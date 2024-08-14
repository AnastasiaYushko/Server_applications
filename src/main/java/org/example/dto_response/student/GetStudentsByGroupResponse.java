package org.example.dto_response.student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetStudentsByGroupResponse {
    private ArrayList<String> listStudents;

    public GetStudentsByGroupResponse(ArrayList<String> listStudents) {
        this.listStudents = new ArrayList<>(listStudents);
    }

    public GetStudentsByGroupResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentsByGroupResponse that = (GetStudentsByGroupResponse) o;
        return Objects.equals(listStudents, that.listStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(listStudents);
    }
}
