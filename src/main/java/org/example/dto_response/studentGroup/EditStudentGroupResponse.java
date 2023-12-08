package org.example.dto_response.studentGroup;

public class EditStudentGroupResponse {
    private String newName;

    public EditStudentGroupResponse(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
