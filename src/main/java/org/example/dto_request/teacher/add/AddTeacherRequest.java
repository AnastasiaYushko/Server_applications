package org.example.dto_request.teacher.add;

public class AddTeacherRequest {
    private String lastName;
    private String firstName;
    private String middleName;

    public AddTeacherRequest(String lastName,String firstName,String middleName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public AddTeacherRequest(){
        super();
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
