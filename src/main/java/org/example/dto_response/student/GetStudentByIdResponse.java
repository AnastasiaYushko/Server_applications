package org.example.dto_response.student;

import java.util.Objects;

public class GetStudentByIdResponse {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;

    public GetStudentByIdResponse(String lastName,String firstName,String middleName,String status,String group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.group = group;
    }

    public GetStudentByIdResponse(){
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetStudentByIdResponse that)) return false;
        return getLastName().equals(that.getLastName()) && getFirstName().equals(that.getFirstName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && getStatus().equals(that.getStatus()) && getGroup().equals(that.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getFirstName(), getMiddleName(), getStatus(), getGroup());
    }
}
