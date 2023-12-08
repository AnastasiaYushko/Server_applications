package org.example.dto_response.teacher;

import java.util.ArrayList;

public class GetTeachersResponse {
    private ArrayList<String> listTeachers;

    public GetTeachersResponse(ArrayList<String> listTeachers){
        this.listTeachers = new ArrayList<>(listTeachers);
    }

    public ArrayList<String> getListTeachers() {
        return listTeachers;
    }

    public void setListTeachers(ArrayList<String> listTeachers) {
        this.listTeachers = new ArrayList<>(listTeachers);
    }
}
