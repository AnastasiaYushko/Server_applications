package org.example.dto_response.subject;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSubjectsResponse that)) return false;
        return Objects.equals(getListSubjects(), that.getListSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListSubjects());
    }
}
