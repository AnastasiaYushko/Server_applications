package org.example.dto_response.student;

import java.util.ArrayList;

public class GetStudentsByGroupResponse {
    private ArrayList<String> listStudents;

    public GetStudentsByGroupResponse(ArrayList<String> listStudents){
        this.listStudents = new ArrayList<>(listStudents);
    }

    public ArrayList<String> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<String> listStudents) {
        this.listStudents = listStudents;
    }
}
