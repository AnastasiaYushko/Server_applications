package org.example.dto_response.studentGroup;

import java.util.Objects;

public class EditStudentGroupResponse {
    private String newName;

    public EditStudentGroupResponse(String newName) {
        this.newName = newName;
    }

    public EditStudentGroupResponse(){
        super();
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EditStudentGroupResponse that)) return false;
        return Objects.equals(getNewName(), that.getNewName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewName());
    }
}
