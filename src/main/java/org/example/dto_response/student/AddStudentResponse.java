package org.example.dto_response.student;

import java.util.Objects;

public class AddStudentResponse {
    private int id;

    public AddStudentResponse(int id){
        this.id = id;
    }

    public AddStudentResponse(){
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
        if (!(o instanceof AddStudentResponse that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
