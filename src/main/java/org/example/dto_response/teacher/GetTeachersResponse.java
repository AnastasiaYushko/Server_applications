package org.example.dto_response.teacher;

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
public class GetTeachersResponse {
    private ArrayList<String> listTeachers;

    public GetTeachersResponse(ArrayList<String> listTeachers) {
        this.listTeachers = new ArrayList<>(listTeachers);
    }

    public GetTeachersResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTeachersResponse that = (GetTeachersResponse) o;
        return Objects.equals(listTeachers, that.listTeachers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(listTeachers);
    }
}
