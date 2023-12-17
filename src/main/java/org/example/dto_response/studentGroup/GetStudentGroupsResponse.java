package org.example.dto_response.studentGroup;

import java.util.ArrayList;
import java.util.Objects;

public class GetStudentGroupsResponse {
    private ArrayList<String> groups;

    public GetStudentGroupsResponse(ArrayList<String> groups) {
        this.groups = new ArrayList<>(groups);
    }

    public GetStudentGroupsResponse() {
        super();
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
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
