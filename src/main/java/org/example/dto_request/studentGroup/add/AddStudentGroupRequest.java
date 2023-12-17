package org.example.dto_request.studentGroup.add;

public class AddStudentGroupRequest {
    private String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public AddStudentGroupRequest() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
