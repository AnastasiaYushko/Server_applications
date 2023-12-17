package org.example.dto_request.student.edit;

public class EditStudentRequest {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;

    public EditStudentRequest(int id, String lastName, String firstName, String middleName, String status, String groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.group = groupId;
    }

    public EditStudentRequest() {
        super();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStatus() {
        return status;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }
}
