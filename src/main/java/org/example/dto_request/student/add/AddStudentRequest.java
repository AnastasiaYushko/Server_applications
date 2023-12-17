package org.example.dto_request.student.add;

public class AddStudentRequest {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String groupId;

    public AddStudentRequest(String lastName, String firstName, String middleName, String status, String groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
    }

    public AddStudentRequest() {
        super();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGroup(String groupId) {
        this.groupId = groupId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }
}
