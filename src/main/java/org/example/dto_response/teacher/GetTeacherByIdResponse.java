package org.example.dto_response.teacher;

public class GetTeacherByIdResponse {
    private String firstName;
    private String lastName;
    private String middleName;

    public GetTeacherByIdResponse(String firstName,String lastName,String middleName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
