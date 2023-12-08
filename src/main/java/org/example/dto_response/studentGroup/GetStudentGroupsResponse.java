package org.example.dto_response.studentGroup;

import java.util.ArrayList;

public class GetStudentGroupsResponse {
    private ArrayList<String> groups;

    public GetStudentGroupsResponse(ArrayList<String> groups){
        this.groups = new ArrayList<>(groups);
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }
}
