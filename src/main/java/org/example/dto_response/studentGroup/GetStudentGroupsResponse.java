package org.example.dto_response.studentGroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
public class GetStudentGroupsResponse {
    private ArrayList<String> groups;

    public GetStudentGroupsResponse(ArrayList<String> groups) {
        this.groups = new ArrayList<>(groups);
    }

    public GetStudentGroupsResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetStudentGroupsResponse that)) return false;
        return Objects.equals(getGroups(), that.getGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroups());
    }
}
