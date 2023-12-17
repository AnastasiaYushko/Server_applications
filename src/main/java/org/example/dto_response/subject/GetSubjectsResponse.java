package org.example.dto_response.subject;

import java.util.ArrayList;

public class GetSubjectsResponse {
    private ArrayList<String> listSubjects;

    public GetSubjectsResponse(ArrayList<String> listSubjects) {
        this.listSubjects = new ArrayList<>(listSubjects);
    }

    public GetSubjectsResponse() {
        super();
    }

    public ArrayList<String> getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(ArrayList<String> listSubjects) {
        this.listSubjects = listSubjects;
    }
}
