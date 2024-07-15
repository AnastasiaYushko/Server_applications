package org.example.dto_response.student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
public class GetStudentByIdResponse {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;

    public GetStudentByIdResponse(String lastName, String firstName, String middleName, String status, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.group = group;
    }

    public GetStudentByIdResponse() {
        super();
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
