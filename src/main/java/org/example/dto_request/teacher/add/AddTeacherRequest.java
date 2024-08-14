package org.example.dto_request.teacher.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class AddTeacherRequest {
    private String lastName;
    private String firstName;
    private String middleName;

    public AddTeacherRequest(String lastName, String firstName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public AddTeacherRequest() {
    }
}
