package org.example.dto_response.student;

import java.util.ArrayList;
import java.util.Objects;

public class GetStudentsByGroupResponse {
    private ArrayList<String> listStudents;

    public GetStudentsByGroupResponse(ArrayList<String> listStudents){
        this.listStudents = new ArrayList<>(listStudents);
    }

    public GetStudentsByGroupResponse(){
        super();
    }

    public ArrayList<String> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<String> listStudents) {
        this.listStudents = listStudents;
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
