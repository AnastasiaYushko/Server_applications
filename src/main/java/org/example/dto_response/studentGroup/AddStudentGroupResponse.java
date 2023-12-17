package org.example.dto_response.studentGroup;

import java.util.Objects;

public class AddStudentGroupResponse {
    private int id;

    public AddStudentGroupResponse(int id){
        this.id = id;
    }

    public AddStudentGroupResponse(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddStudentGroupResponse that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
