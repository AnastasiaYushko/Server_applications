package org.example.dto_response.teacher;

import java.util.Objects;

public class GetTeacherByIdResponse {
    private String firstName;
    private String lastName;
    private String middleName;

    public GetTeacherByIdResponse(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public GetTeacherByIdResponse() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetTeacherByIdResponse that)) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && Objects.equals(getMiddleName(), that.getMiddleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName());
    }
}
