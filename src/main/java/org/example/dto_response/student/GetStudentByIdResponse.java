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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdResponse that = (GetStudentByIdResponse) o;
        return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(status, that.status) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, status, group);
    }
}
