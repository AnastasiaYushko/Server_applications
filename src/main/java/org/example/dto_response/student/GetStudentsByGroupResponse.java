package org.example.dto_response.student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
public class GetStudentsByGroupResponse {
    private ArrayList<String> listStudents;

    public GetStudentsByGroupResponse(ArrayList<String> listStudents) {
        this.listStudents = new ArrayList<>(listStudents);
    }

    public GetStudentsByGroupResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetStudentsByGroupResponse that)) return false;
        return getListStudents().equals(that.getListStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListStudents());
    }
}
