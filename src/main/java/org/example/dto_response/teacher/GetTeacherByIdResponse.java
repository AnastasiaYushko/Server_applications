package org.example.dto_response.teacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@Component
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
