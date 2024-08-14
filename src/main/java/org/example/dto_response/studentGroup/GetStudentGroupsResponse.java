package org.example.dto_response.studentGroup;

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
public class GetStudentGroupsResponse {
    private ArrayList<String> groups;

    public GetStudentGroupsResponse(ArrayList<String> groups) {
        this.groups = new ArrayList<>(groups);
    }

    public GetStudentGroupsResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentGroupsResponse that = (GetStudentGroupsResponse) o;
        return Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(groups);
    }
}
