package org.example.dto_response.student;

public class EditStudentResponse {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;

    public EditStudentResponse(String lastName, String firstName, String middleName, String status, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        return group;
    }

    public String getStatus() {
        return status;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
