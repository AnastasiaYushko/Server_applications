package org.example.dto_request.student.edit;

public class EditStudentRequest {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private int groupId;

    public EditStudentRequest(int id,String lastName,String firstName,String middleName,String status,int groupId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
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

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public int getGroupId() {
        return groupId;
    }

    public int getId() {
        return id;
    }
}
